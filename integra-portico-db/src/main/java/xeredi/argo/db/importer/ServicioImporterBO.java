package xeredi.argo.db.importer;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import oracle.sql.TIMESTAMP;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.proxy.PorticoResourceBundle;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioImporterBO.
 */
public final class ServicioImporterBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ServicioImporterBO.class);

    /** The bundle. */
    private static ResourceBundle bundle;

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

    /** The prto map. */
    private final Map<String, PuertoVO> prtoMap = new HashMap<>();

    /**
     * Import entities.
     *
     * @param numIterations
     *            the num iterations
     * @param locale
     *            the locale
     */
    public void importEntities(final int numIterations, final Locale locale) {
        for (int i = 0; i < numIterations; i++) {
            LOG.info("Iteration: " + i);

            importEntities(locale);
        }
    }

    /**
     * Import entities.
     *
     * @param locale
     *            the locale
     */
    public void importEntities(final Locale locale) {
        try {
            LOG.info("Importacion de servicios");

            bundle = PorticoResourceBundle.getBundle(locale);

            Class.forName(ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_driver));

            try (final Connection con = DriverManager.getConnection(
                    ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_url),
                    ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_username),
                    ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_password));) {

                entidadesList.clear();
                entidadesSqlMap.clear();

                parseXml(entidadesList, entidadesSqlMap);

                entiMap = new HashMap<>();

                for (final Entidad entidad : entidadesList) {
                    final ServicioNodoVO entidadVO = entidadesSqlMap.get(entidad);

                    entiMap.put(entidad.getId(), new HashMap<Long, Long>());

                    importEntity(con, entidadVO.getEntidad(), entidadVO.getSqlQuery(), locale);
                }
            } catch (final Throwable ex) {
                LOG.fatal(ex, ex);
            }
        } catch (final Throwable ex) {
            LOG.fatal(ex, ex);
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
     * @param locale
     *            the locale
     * @throws SQLException
     *             the sQL exception
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    private void importEntity(final Connection con, final Entidad entidad, final StringBuffer sql, final Locale locale)
            throws SQLException, DuplicateInstanceException {
        final ServicioBO srvcBO = ServicioBOFactory.newDefaultInstance();
        final SubservicioBO ssrvBO = SubservicioBOFactory.newDefaultInstance();

        final AbstractEntidadDetailVO entiDetail = EntidadProxy.select(entidad.getId());
        final String entiName = bundle.getString(ClassPrefix.enti.name() + "_" + entiDetail.getEnti().getId());

        if (LOG.isInfoEnabled()) {
            LOG.info("Importacion de la entidad: " + entiName);
        }

        // Obtencion de los maestros asociados a la entidad
        for (final Long tpdtId : entiDetail.getEntdList()) {
            final EntidadTipoDatoVO entd = entiDetail.getEntdMap().get(tpdtId);

            if (entd.getTpdt().getEnti() != null && !tpprPrmtMap.containsKey(entd.getTpdt().getEnti().getId())) {
                if (LOG.isDebugEnabled()) {
                    final String tpprName = bundle.getString(ClassPrefix.enti.name() + "_"
                            + entd.getTpdt().getEnti().getId());

                    LOG.debug("Busqueda de los parametros del maestro " + tpprName);
                }

                final ParametroBO prmtBO = ParametroBOFactory.newInstance(entd.getTpdt().getEnti().getId());
                final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

                prmtCriterioVO.setEntiId(entd.getTpdt().getEnti().getId());
                tpprPrmtMap.put(entd.getTpdt().getEnti().getId(), prmtBO.selectMapCodigoId(prmtCriterioVO));
            }
        }

        // Obtencion de Subpuertos
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        for (final PuertoVO prto : prtoBO.selectList(prtoCriterio)) {
            prtoMap.put(prto.getCodigoCorto(), prto);
        }

        ResultSet rs = null;

        try (final PreparedStatement stmt = con.prepareStatement(sql.toString());) {
            int i = 1;
            int numeroSubservicio = 1;

            rs = stmt.executeQuery();

            while (rs.next()) {
                i = 1;

                Long servId = null;
                ServicioVO srvcVO = null;

                switch (entiDetail.getEnti().getTipo()) {
                case T:
                    final TipoServicioDetailVO tpsrDetail = TipoServicioProxy.select(entiDetail.getEnti().getId());

                    srvcVO = new ServicioVO();
                    srvcVO.setEntiId(tpsrDetail.getEnti().getId());

                    servId = rs.getLong(i++);
                    final Date fechaCreacion = rs.getDate(i++);
                    final Date fechaBaja = rs.getDate(i++);
                    final Date fechaModificacion = rs.getDate(i++);
                    final String tipo = rs.getString(i++);
                    final String moduloCod = rs.getString(i++);
                    final String subpuertoCod = rs.getString(i++);
                    final String anno = rs.getString(i++);
                    final String numero = rs.getString(i++);

                    Date fechaEstadistica = null;
                    final Timestamp tsEstadistica = rs.getTimestamp(i++);
                    if (!rs.wasNull()) {
                        fechaEstadistica = new Date(tsEstadistica.getTime());
                    }

                    Date fechaAnulaFactura = null;
                    final Timestamp tsAnulaFactura = rs.getTimestamp(i++);
                    if (!rs.wasNull()) {
                        fechaAnulaFactura = new Date(tsAnulaFactura.getTime());
                    }

                    Date fechaReferencia = null;
                    final Timestamp tsReferencia = rs.getTimestamp(i++);
                    if (!rs.wasNull()) {
                        fechaReferencia = new Date(tsReferencia.getTime());
                    }

                    if (!prtoMap.containsKey(subpuertoCod)) {
                        throw new Error("Subpuerto " + subpuertoCod + " no encontrado");
                    }

                    srvcVO.setPrto(prtoMap.get(subpuertoCod));
                    srvcVO.setAnno(anno);
                    srvcVO.setNumero(numero);
                    srvcVO.setFalta(fechaCreacion);
                    srvcVO.setFbaja(fechaBaja);
                    srvcVO.setFref(fechaReferencia);

                    if (tpsrDetail.getEnti().isTemporal()) {
                        Date fechaInicio = null;
                        Date fechaFin = null;

                        final Timestamp tsInicio = rs.getTimestamp(i++);

                        if (!rs.wasNull()) {
                            fechaInicio = new Date(tsInicio.getTime());
                        }

                        final Timestamp tsFin = rs.getTimestamp(i++);

                        if (!rs.wasNull()) {
                            fechaFin = new Date(tsFin.getTime());
                        }

                        srvcVO.setFini(fechaInicio);
                        srvcVO.setFfin(fechaFin);
                    }

                    if (tpsrDetail.getEnti().getTpdtEstado() != null) {
                        final String estado = rs.getString(i++);

                        if (estado == null) {
                            throw new Error("Estado obligatorio para el servicio");
                        }

                        srvcVO.setEstado(estado);
                    }

                    if (tpsrDetail.getEntdList() != null) {
                        srvcVO.setItdtMap(new HashMap<Long, ItemDatoVO>());

                        for (final Long tpdtId : tpsrDetail.getEntdList()) {
                            final EntidadTipoDatoVO entd = tpsrDetail.getEntdMap().get(tpdtId);

                            final Object value = rs.getObject(i++);

                            if (rs.wasNull() && entd.getObligatorio()
                                    && entd.getTpdt().getTipoElemento() != TipoElemento.BO) {
                                final String tpdtName = bundle.getString(ClassPrefix.tpdt.name() + "_"
                                        + entd.getTpdt().getId());

                                throw new Error("Campo obligatorio no encontrado para el dato: " + tpdtName
                                        + " de la entidad: " + entiName);
                            }

                            final ItemDatoVO itdtVO = getItemDato(entd, value);

                            srvcVO.getItdtMap().put(entd.getTpdt().getId(), itdtVO);
                        }
                    }

                    try {
                        srvcBO.insert(srvcVO, null, null, null);
                        entiMap.get(entiDetail.getEnti().getId()).put(servId, srvcVO.getId());
                    } catch (final DuplicateInstanceException ex) {
                        LOG.info(ex.getMessage(locale));
                    }

                    break;
                case S:
                    final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy
                            .select(entiDetail.getEnti().getId());
                    final SubservicioVO ssrvVO = new SubservicioVO();
                    srvcVO = new ServicioVO();
                    servId = rs.getLong(i++);

                    srvcVO.setId(entiMap.get(tpssDetail.getEnti().getTpsrId()).get(servId));
                    ssrvVO.setSrvc(srvcVO);
                    ssrvVO.setEntiId(tpssDetail.getEnti().getId());

                    final Long subservId = rs.getLong(i++);

                    if (ssrvVO.getSrvc().getId() == null) {
                        LOG.error("No se encuentra servicio para " + entiName + " " + subservId + " del servicio "
                                + servId);
                    } else {
                        // FIXME
                        rs.getInt(i++);
                        ssrvVO.setNumero(numeroSubservicio++);

                        if (tpssDetail.getEnti().isTemporal()) {
                            Date fechaInicio = null;
                            Date fechaFin = null;

                            final Timestamp tsInicio = rs.getTimestamp(i++);

                            if (!rs.wasNull()) {
                                fechaInicio = new Date(tsInicio.getTime());
                            }

                            final Timestamp tsFin = rs.getTimestamp(i++);

                            if (!rs.wasNull()) {
                                fechaFin = new Date(tsFin.getTime());
                            }

                            ssrvVO.setFini(fechaInicio);
                            ssrvVO.setFfin(fechaFin);
                        }

                        if (tpssDetail.getEnti().getTpdtEstado() != null) {
                            final String estado = rs.getString(i++);

                            if (estado == null) {
                                throw new Error("Estado obligatorio para el subservicio");
                            }

                            ssrvVO.setEstado(estado);
                        }

                        final Set<Long> padreIds = new HashSet<>();

                        boolean hasErrors = false;

                        if (tpssDetail.getEntiPadresList() != null) {
                            for (final Long entdId : tpssDetail.getEntiPadresList()) {
                                if (!entdId.equals(tpssDetail.getEnti().getTpsrId())) {
                                    final Long padreIntegraId = rs.getLong(i++);
                                    final Long padrePorticoId = entiMap.get(entdId).get(padreIntegraId);

                                    if (padrePorticoId == null) {
                                        final String entiPadreName = bundle.getString(ClassPrefix.enti.name() + "_"
                                                + entdId);

                                        LOG.error("No se encuentra el subservicio " + padreIntegraId
                                                + " de la entidad " + entiPadreName);

                                        hasErrors = true;
                                    } else {
                                        padreIds.add(padrePorticoId);
                                    }
                                }
                            }
                        }

                        if (tpssDetail.getEntdList() != null) {
                            ssrvVO.setItdtMap(new HashMap<Long, ItemDatoVO>());

                            for (final Long tpdtId : tpssDetail.getEntdList()) {
                                final EntidadTipoDatoVO entd = tpssDetail.getEntdMap().get(tpdtId);
                                final Object value = rs.getObject(i++);

                                if (rs.wasNull() && entd.getObligatorio()
                                        && entd.getTpdt().getTipoElemento() != TipoElemento.BO) {
                                    final String tpdtName = bundle.getString(ClassPrefix.tpdt.name() + "_"
                                            + entd.getTpdt().getId());

                                    throw new Error("Campo obligatorio no encontrado para el dato: " + tpdtName
                                            + " de la entidad: " + entiName);
                                }

                                final ItemDatoVO itdt = getItemDato(entd, value);

                                ssrvVO.getItdtMap().put(entd.getTpdt().getId(), itdt);
                            }
                        }

                        if (!hasErrors) {
                            try {
                                ssrvBO.insert(ssrvVO, tpssDetail, padreIds);
                                entiMap.get(entiDetail.getEnti().getId()).put(subservId, ssrvVO.getId());
                            } catch (final DuplicateInstanceException ex) {
                                LOG.info(ex.getMessage(locale));
                            }
                        }
                    }

                    break;

                default:
                    throw new Error("Tipo de entidad no soportado: " + entiDetail.getEnti().getTipo());
                }
            }

            LOG.info("Grabados: " + entiMap.get(entiDetail.getEnti().getId()).size());
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

        try {
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
                    final Long prmtId = tpprPrmtMap.get(entdVO.getTpdt().getEnti().getId()).get(
                            value.toString().toUpperCase());

                    if (prmtId == null) {
                        final String entiName = bundle.getString(ClassPrefix.enti.name() + "_"
                                + entdVO.getTpdt().getEnti().getId());
                        final String tpdtName = bundle.getString(ClassPrefix.tpdt.name() + "_"
                                + entdVO.getTpdt().getId());

                        final String errorMessage = "Parametro no encontrado para el codigo: " + value
                                + " en el tipo de dato: " + tpdtName + " del maestro: " + entiName;

                        throw new Error(errorMessage);
                    }

                    final ParametroVO prmtVO = new ParametroVO();

                    prmtVO.setId(prmtId);
                    itdtVO.setPrmt(prmtVO);

                    break;
                case SR:
                    final Long srvcId = entiMap.get(entdVO.getTpdt().getEnti().getId()).get(
                            Long.valueOf(value.toString()));

                    if (srvcId == null) {
                        final String entiName = bundle.getString(ClassPrefix.enti.name() + "_"
                                + entdVO.getTpdt().getEnti().getId());
                        final String tpdtName = bundle.getString(ClassPrefix.tpdt.name() + "_"
                                + entdVO.getTpdt().getId());

                        final String errorMessage = "Servicio no encontrado para el id: " + value
                                + " en el tipo de dato: " + tpdtName + " del tipo de servicio: " + entiName;

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
        } catch (final Throwable ex) {
            LOG.fatal("Error leyendo itdt");
            LOG.fatal("Entidad: " + entdVO.getEntiId());
            LOG.fatal("Tipo de Dato: " + entdVO.getTpdt().getCodigo());
            LOG.fatal("Valor: " + value);
            LOG.fatal(ex.getMessage(), ex);

            throw ex;
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
