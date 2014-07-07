package xeredi.integra.db.importer;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import oracle.sql.TIMESTAMP;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import xeredi.integra.model.bo.maestro.Parametro;
import xeredi.integra.model.bo.servicio.Servicio;
import xeredi.integra.model.bo.servicio.Subservicio;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.proxy.metamodelo.EntidadProxy;
import xeredi.integra.model.proxy.metamodelo.TipoServicioProxy;
import xeredi.integra.model.proxy.metamodelo.TipoSubservicioProxy;
import xeredi.integra.model.util.ConfigurationUtil;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.maestro.ParametroCriterioVO;
import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;
import xeredi.integra.model.vo.metamodelo.TipoElemento;
import xeredi.integra.model.vo.metamodelo.TipoServicioVO;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioVO;
import xeredi.integra.model.vo.servicio.ServicioVO;
import xeredi.integra.model.vo.servicio.SubservicioVO;
import xeredi.util.exception.DuplicateInstanceException;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioImporterBO.
 */
public final class ServicioImporterBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ServicioImporterBO.class);

    /** The Constant SERVICIO_FILENAME. */
    private static final String SERVICIO_FILENAME = "/xeredi/integra/db/importer/ServicioImporter.xml";

    /** The Constant XML_ID_ATTR. */
    private static final String XML_ID_ATTR = "id";

    /** The Constant XML_SQL_ELEM. */
    private static final String XML_SQL_ELEM = "sql";

    /** The entidades list. */
    private final List<Entidad> entidadesList = new ArrayList<>();

    /** The entidades sql map. */
    private final Map<Entidad, ServicioNodoVO> entidadesSqlMap = new HashMap<>();

    /**
     * Map de entidades (id integra, id portico), indexados por tipo de entidad.
     */
    private Map<Long, Map<Long, Long>> entiMap;

    /** Map de parametros (codigo, id), indexados por tipo de parametro. */
    private final Map<Long, Map<String, Long>> tpprPrmtMap = new HashMap<>();

    /**
     * Import entities.
     */
    public void importEntities() {
        Connection con = null;

        try {
            LOG.info("Importacion de servicios");

            final Configuration configuration = ConfigurationUtil.getConfiguration();

            Class.forName(configuration.getString("db.migration.dataSource.driver"));

            con = DriverManager.getConnection(configuration.getString("db.migration.dataSource.url"),
                    configuration.getString("db.migration.dataSource.username"),
                    configuration.getString("db.migration.dataSource.password"));

            parseXml(entidadesList, entidadesSqlMap);

            entiMap = new HashMap<>();

            for (final Entidad entidad : entidadesList) {
                final ServicioNodoVO entidadVO = entidadesSqlMap.get(entidad);

                entiMap.put(entidad.getId(), new HashMap<Long, Long>());

                importEntity(con, entidadVO.getEntidad(), entidadVO.getSqlQuery());
            }
        } catch (final Throwable ex) {
            LOG.fatal(ex, ex);
        } finally {
            DbUtils.closeQuietly(con);
        }

        LOG.info("Fin de Importacion de servicios");
    }

    /**
     * Import entity.
     *
     * @param con
     *            the con
     * @param entidad
     *            the entidad
     * @param sql
     *            the sql
     * @throws SQLException
     *             the sQL exception
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    private void importEntity(final Connection con, final Entidad entidad, final StringBuffer sql) throws SQLException,
    DuplicateInstanceException {
        final Parametro prmtBO = BOFactory.getInjector().getInstance(Parametro.class);
        final Servicio srvcBO = BOFactory.getInjector().getInstance(Servicio.class);
        final Subservicio ssrvBO = BOFactory.getInjector().getInstance(Subservicio.class);
        final EntidadVO entiVO = EntidadProxy.select(entidad.getId());

        if (entiVO == null) {
            throw new Error("No se encuentra la entidad con id: " + entidad.getId());
        }

        if (LOG.isInfoEnabled()) {
            LOG.info("Importacion de la entidad: " + entiVO.getNombre());
        }

        // Obtencion de los maestros asociados a la entidad
        for (final EntidadTipoDatoVO entdVO : entiVO.getEntdMap().values()) {
            if (entdVO.getTpdt().getEnti() != null && !tpprPrmtMap.containsKey(entdVO.getTpdt().getEnti().getId())) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Busqueda de los parametros del maestro " + entdVO.getTpdt().getEnti().getNombre());
                }

                final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

                prmtCriterioVO.setEntiId(entdVO.getTpdt().getEnti().getId());
                tpprPrmtMap.put(entdVO.getTpdt().getEnti().getId(), prmtBO.selectMapCodigoId(prmtCriterioVO));
            }
        }

        // Obtencion de Subpuertos
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setEntiId(Entidad.SUBPUERTO.getId());
        tpprPrmtMap.put(Entidad.SUBPUERTO.getId(), prmtBO.selectMapCodigoId(prmtCriterioVO));

        ResultSet rs = null;

        try (final PreparedStatement stmt = con.prepareStatement(sql.toString());) {
            int i = 1;
            int numeroSubservicio = 1;

            rs = stmt.executeQuery();

            while (rs.next()) {
                i = 1;

                Long servId = null;
                ServicioVO srvcVO = null;

                switch (entiVO.getTipo()) {
                case T:
                    final TipoServicioVO tpsrVO = TipoServicioProxy.select(entiVO.getId());

                    srvcVO = ServicioVO.newInstance(tpsrVO);

                    servId = rs.getLong(i++);
                    final Date fechaCreacion = rs.getDate(i++);
                    final Date fechaBaja = rs.getDate(i++);
                    final Date fechaModificacion = rs.getDate(i++);
                    final String tipo = rs.getString(i++);
                    final String moduloCod = rs.getString(i++);
                    final String subpuertoCod = rs.getString(i++);
                    final String anno = rs.getString(i++);
                    final String numero = rs.getString(i++);
                    final Date fechaEstadistica = rs.getDate(i++);
                    final Date fechaAnulaFactura = rs.getDate(i++);
                    final Date fechaReferencia = rs.getDate(i++);
                    final Long prmtSubpuertoId = tpprPrmtMap.get(Entidad.SUBPUERTO.getId()).get(subpuertoCod);

                    if (prmtSubpuertoId == null) {
                        throw new Error("Subpuerto " + subpuertoCod + " no encontrado");
                    }

                    final ParametroVO prmtSubpuertoVO = new ParametroVO();

                    prmtSubpuertoVO.setId(prmtSubpuertoId);

                    srvcVO.setSubp(prmtSubpuertoVO);
                    srvcVO.setAnno(anno);
                    srvcVO.setNumero(numero);
                    srvcVO.setFalta(fechaCreacion);
                    srvcVO.setFbaja(fechaBaja);
                    srvcVO.setFreferencia(fechaReferencia);

                    if (tpsrVO.isTemporal()) {
                        final Date fechaInicio = rs.getDate(i++);
                        final Date fechaFin = rs.getDate(i++);

                        srvcVO.setFinicio(fechaInicio);
                        srvcVO.setFfin(fechaFin);
                    }

                    if (tpsrVO.getTpdtEstado() != null) {
                        final String estado = rs.getString(i++);

                        if (estado == null) {
                            throw new Error("Estado obligatorio para el servicio");
                        }

                        srvcVO.setEstado(estado);
                    }

                    if (tpsrVO.getEntdList() != null) {
                        for (final Long entdId : tpsrVO.getEntdList()) {
                            final EntidadTipoDatoVO entdVO = tpsrVO.getEntdMap().get(entdId);
                            final Object value = rs.getObject(i++);

                            if (LOG.isTraceEnabled()) {
                                LOG.trace("Guardar " + value + " en el dato " + entdVO.getTpdt().getNombre());
                            }

                            if (rs.wasNull() && entdVO.isObligatorio()
                                    && entdVO.getTpdt().getTipoElemento() != TipoElemento.BO) {
                                throw new Error("Campo obligatorio no encontrado para el dato: "
                                        + entdVO.getTpdt().getNombre() + " de la entidad: " + entiVO.getNombre());
                            }

                            final ItemDatoVO itdtVO = getItemDato(entdVO, value);

                            srvcVO.getItdtMap().put(entdVO.getTpdt().getId(), itdtVO);
                        }
                    }

                    try {
                        if (LOG.isTraceEnabled()) {
                            LOG.trace(srvcVO);
                        }

                        srvcBO.insert(srvcVO, null);
                        entiMap.get(entiVO.getId()).put(servId, srvcVO.getId());
                    } catch (final DuplicateInstanceException ex) {
                        LOG.info(entiVO.getNombre() + " Duplicado: " + srvcVO.getEtiqueta());
                    }

                    break;
                case S:
                    final TipoSubservicioVO tpssVO = TipoSubservicioProxy.select(entiVO.getId());
                    final SubservicioVO ssrvVO = SubservicioVO.newInstance(tpssVO);
                    srvcVO = new ServicioVO();
                    servId = rs.getLong(i++);

                    srvcVO.setId(entiMap.get(tpssVO.getTpsr().getId()).get(servId));
                    ssrvVO.setSrvc(srvcVO);

                    final Long subservId = rs.getLong(i++);

                    if (ssrvVO.getSrvc().getId() == null) {
                        LOG.error("No se encuentra servicio para " + tpssVO.getEtiqueta() + " " + subservId
                                + " del servicio " + servId);
                    } else {
                        // FIXME
                        rs.getInt(i++);
                        ssrvVO.setNumero(numeroSubservicio++);

                        if (tpssVO.isTemporal()) {
                            final Date fechaInicio = rs.getDate(i++);
                            final Date fechaFin = rs.getDate(i++);

                            ssrvVO.setFinicio(fechaInicio);
                            ssrvVO.setFfin(fechaFin);
                        }

                        if (tpssVO.getTpdtEstado() != null) {
                            final String estado = rs.getString(i++);

                            if (estado == null) {
                                throw new Error("Estado obligatorio para el subservicio");
                            }

                            ssrvVO.setEstado(estado);
                        }

                        final Set<Long> padreIds = new HashSet<>();

                        boolean hasErrors = false;

                        if (tpssVO.getEntiPadresList() != null) {
                            for (final Long entdId : tpssVO.getEntiPadresList()) {
                                if (!entdId.equals(tpssVO.getTpsr().getId())) {
                                    final Long padreIntegraId = rs.getLong(i++);
                                    final Long padrePorticoId = entiMap.get(entdId).get(padreIntegraId);

                                    if (padrePorticoId == null) {
                                        LOG.error("No se encuentra el subservicio " + padreIntegraId
                                                + " de la entidad " + TipoSubservicioProxy.select(entdId).getEtiqueta());

                                        hasErrors = true;
                                    } else {
                                        padreIds.add(padrePorticoId);
                                    }
                                }
                            }
                        }

                        if (tpssVO.getEntdList() != null) {
                            for (final Long entdId : tpssVO.getEntdList()) {
                                final EntidadTipoDatoVO entdVO = tpssVO.getEntdMap().get(entdId);
                                final Object value = rs.getObject(i++);

                                if (LOG.isTraceEnabled()) {
                                    LOG.trace("Guardar " + value + " en el dato " + entdVO.getTpdt().getNombre());
                                }

                                if (rs.wasNull() && entdVO.isObligatorio()
                                        && entdVO.getTpdt().getTipoElemento() != TipoElemento.BO) {
                                    throw new Error("Campo obligatorio no encontrado para el dato: "
                                            + entdVO.getTpdt().getNombre() + " de la entidad: " + entiVO.getNombre());
                                }

                                final ItemDatoVO itdtVO = getItemDato(entdVO, value);

                                ssrvVO.getItdtMap().put(entdVO.getTpdt().getId(), itdtVO);
                            }
                        }

                        if (!hasErrors) {
                            try {
                                if (LOG.isTraceEnabled()) {
                                    LOG.trace(ssrvVO);
                                }

                                ssrvBO.insert(ssrvVO, padreIds);
                                entiMap.get(entiVO.getId()).put(subservId, ssrvVO.getId());
                            } catch (final DuplicateInstanceException ex) {
                                LOG.info(entiVO.getNombre() + " Duplicado: " + ssrvVO);
                            }
                        }
                    }

                    break;

                default:
                    throw new Error("Tipo de entidad no soportado: " + entiVO.getTipo());
                }
            }

            LOG.info("Grabados: " + entiMap.get(entiVO.getId()).size());
        } finally {
            DbUtils.closeQuietly(rs);
        }
    }

    /**
     * Gets the item dato.
     *
     * @param entdVO
     *            the entd vo
     * @param value
     *            the value
     * @return the item dato
     * @throws SQLException
     *             the sQL exception
     */
    private ItemDatoVO getItemDato(final EntidadTipoDatoVO entdVO, final Object value) throws SQLException {
        final ItemDatoVO itdtVO = new ItemDatoVO();

        itdtVO.setTpdtId(entdVO.getTpdt().getId());

        if (value == null) {
            if (entdVO.getTpdt().getTipoElemento() == TipoElemento.BO) {
                itdtVO.setCantidadEntera(0L);
            }
        } else {
            switch (entdVO.getTpdt().getTipoElemento()) {
            case BO:
                itdtVO.setCantidadEntera(((BigDecimal) value).longValue());

                break;
            case ND:
                itdtVO.setCantidadDecimal(((BigDecimal) value).doubleValue());

                break;
            case NE:
                itdtVO.setCantidadEntera(((BigDecimal) value).longValue());

                break;
            case PR:
                final Long prmtId = tpprPrmtMap.get(entdVO.getTpdt().getEnti().getId()).get(value);

                if (prmtId == null) {
                    final String errorMessage = "Parametro no encontrado para el codigo: " + value
                            + " en el tipo de dato: " + entdVO.getTpdt().getNombre() + " del maestro: "
                            + entdVO.getTpdt().getEnti().getNombre();

                    throw new Error(errorMessage);
                }

                final ParametroVO prmtVO = new ParametroVO();

                prmtVO.setId(prmtId);
                itdtVO.setPrmt(prmtVO);

                break;
            case SR:
                final Long srvcId = entiMap.get(entdVO.getTpdt().getEnti().getId()).get(Long.valueOf(value.toString()));

                if (srvcId == null) {
                    final String errorMessage = "Servicio no encontrado para el id: " + value + " en el tipo de dato: "
                            + entdVO.getTpdt().getNombre() + " del tipo de servicio: "
                            + entdVO.getTpdt().getEnti().getNombre();

                    throw new Error(errorMessage);
                }

                final ServicioVO srvcVO = new ServicioVO();

                srvcVO.setId(srvcId);
                itdtVO.setSrvc(srvcVO);

                break;
            case CR:
            case TX:
                itdtVO.setCadena((String) value);

                break;
            case FE:
            case FH:
                if (value instanceof TIMESTAMP) {
                    itdtVO.setFecha(((TIMESTAMP) value).dateValue());
                } else {
                    itdtVO.setFecha((Date) value);
                }

                break;

            default:
                throw new Error("TipoElemento no encontrado: " + entdVO.getTpdt().getTipoElemento());
            }
        }

        return itdtVO;
    }

    /**
     * Parses the xml.
     *
     * @param aserviciosList
     *            the aservicios list
     * @param aserviciosSqlMap
     *            the aservicios sql map
     * @throws ParserConfigurationException
     *             the parser configuration exception
     * @throws SAXException
     *             the sAX exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void parseXml(final List<Entidad> aserviciosList, final Map<Entidad, ServicioNodoVO> aserviciosSqlMap)
            throws ParserConfigurationException, SAXException, IOException {
        LOG.info("Lectura del Archivo XML de consultas de Maestros");

        final SAXParserFactory factory = SAXParserFactory.newInstance();
        final SAXParser saxParser = factory.newSAXParser();

        final DefaultHandler handler = new DefaultHandler() {

            private boolean isSql;

            private Entidad sqlName;

            private StringBuffer sql;

            /**
             * {@inheritDoc}
             */
            @Override
            public void startElement(final String uri, final String localName, final String qName,
                    final Attributes attributes) throws SAXException {
                if (XML_SQL_ELEM.equals(qName)) {
                    isSql = true;

                    sqlName = Entidad.valueOf(attributes.getValue(XML_ID_ATTR));
                    sql = new StringBuffer();
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void characters(final char[] ch, final int start, final int length) throws SAXException {
                if (isSql) {
                    sql.append(new String(ch, start, length));
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void endElement(final String uri, final String localName, final String qName) throws SAXException {
                if (XML_SQL_ELEM.equals(qName)) {
                    aserviciosList.add(sqlName);
                    aserviciosSqlMap.put(sqlName, new ServicioNodoVO(sqlName, sql));

                    isSql = false;
                }
            }

        };

        saxParser.parse(ServicioImporterBO.class.getResourceAsStream(SERVICIO_FILENAME), handler);
    }
}
