package xeredi.integra.db.importer;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.bo.Parametro;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.Subparametro;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.ParametroI18nVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.EntidadProxy;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.util.ConfigurationUtil;
import xeredi.integra.model.util.Entidad;
import xeredi.util.exception.DuplicateInstanceException;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroImporter2BO.
 */
public final class MaestroImporterBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(MaestroImporterBO.class);

    /** The Constant MAESTRO_FILENAME. */
    private static final String MAESTRO_FILENAME = "/xeredi/integra/db/importer/MaestroImporter.xml";

    /** The Constant XML_ID_ATTR. */
    private static final String XML_ID_ATTR = "id";

    /** The Constant XML_TEMPIMP_ATTR. */
    private static final String XML_TEMPIMP_ATTR = "tempImp";

    /** The Constant XML_SQL_ELEM. */
    private static final String XML_SQL_ELEM = "sql";

    /** The idioma. */
    private final String idioma;

    /**
     * The fecha vigencia. La que se toma como referencia para traer los datos vigentes a esa fecha en INTEGRA.
     */
    private final Date fechaVigencia;

    /**
     * Fecha que se utiliza para marcar la fecha de inicio de las versiones de los parametros con temporalidad implicita
     * en la BD.
     */
    private final Date fechaInicioReferencia;

    /** The maestros list. */
    private final List<Entidad> maestrosList = new ArrayList<>();

    /** The maestros sql map. */
    private final Map<Entidad, MaestroNodoVO> maestrosSqlMap = new HashMap<>();

    /** The prmt map. */
    private final Map<Long, Map<String, Long>> tpprPrmtMap = new HashMap<>();

    /**
     * Instantiates a new parametro importer2 bo.
     *
     * @param aidioma
     *            the aidioma
     * @param afechaVigencia
     *            the afecha vigencia
     */
    public MaestroImporterBO(final String aidioma, final Date afechaVigencia) {
        super();
        idioma = aidioma;
        fechaVigencia = afechaVigencia;

        final Calendar calendar = Calendar.getInstance();

        calendar.setTime(afechaVigencia);
        calendar.add(Calendar.YEAR, -10);

        fechaInicioReferencia = calendar.getTime();
    }

    /**
     * Import entities.
     */
    public void importEntities() {
        LOG.info("Importacion de maestros");

        try {
            final Configuration configuration = ConfigurationUtil.getConfiguration();

            Class.forName(configuration.getString("db.migration.dataSource.driver"));

            try (final Connection con = DriverManager.getConnection(
                    configuration.getString("db.migration.dataSource.url"),
                    configuration.getString("db.migration.dataSource.username"),
                    configuration.getString("db.migration.dataSource.password"));) {

                parseXml(maestrosList, maestrosSqlMap);

                for (final Entidad entidad : maestrosList) {
                    final MaestroNodoVO maestroVO = maestrosSqlMap.get(entidad);
                    final EntidadVO entiVO = EntidadProxy.select(maestroVO.getEntidad().getId());

                    switch (entiVO.getTipo()) {
                    case P:
                        if (LOG.isInfoEnabled()) {
                            LOG.info("Importacion del maestro: " + entiVO.getNombre());
                        }

                        importTipoParametro(con, maestroVO.getEntidad(), maestroVO.isTempImp(), maestroVO.getSqlQuery());

                        break;

                    case B:
                        if (LOG.isInfoEnabled()) {
                            LOG.info("Importacion del submaestro: " + entiVO.getNombre());
                        }

                        importSubtipoParametro(con, maestroVO.getEntidad(), maestroVO.isTempImp(),
                                maestroVO.getSqlQuery());

                        break;

                    default:
                        throw new Error("Tipo de entidad: " + entiVO.getTipo() + " no valida para la entidad "
                                + entiVO.getNombre());
                    }
                }
            } catch (final Throwable ex) {
                LOG.fatal(ex, ex);
            }
        } catch (final Throwable ex) {
            LOG.fatal(ex, ex);
        }

        LOG.info("Fin de Importacion de maestros");
    }

    /**
     * Import entity.
     *
     * @param con
     *            the con
     * @param entidad
     *            the entidad
     * @param isTmpImpl
     *            the is tmp impl
     * @param sql
     *            the sql
     * @throws SQLException
     *             the sQL exception
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    private void importTipoParametro(final Connection con, final Entidad entidad, final boolean isTmpImpl,
            final StringBuffer sql) throws SQLException, DuplicateInstanceException {
        final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);
        final TipoParametroVO tpprVO = TipoParametroProxy.select(entidad.getId());

        if (tpprVO == null) {
            throw new Error("No se encuentra el tipo de parametro con id: " + entidad.getId());
        }

        if (!tpprPrmtMap.containsKey(tpprVO.getId())) {
            tpprPrmtMap.put(tpprVO.getId(), new HashMap<String, Long>());
        }

        ResultSet rs = null;

        try (final PreparedStatement stmt = con.prepareStatement(sql.toString());) {
            int i = 1;

            if (tpprVO.getI18n()) {
                stmt.setString(i++, idioma);
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
            }

            if (isTmpImpl) {
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
            }

            rs = stmt.executeQuery();

            while (rs.next()) {
                i = 1;

                final String parametro = rs.getString(i++);

                Date fechaInicio = null;
                Date fechaFin = null;

                if (tpprVO.getTempExp()) {
                    fechaInicio = rs.getDate(i++);
                    fechaFin = rs.getDate(i++);
                } else {
                    fechaInicio = fechaInicioReferencia;
                }

                // Creacion del parametro
                final ParametroVO prmtVO = ParametroVO.newInstance(tpprVO);

                prmtVO.setParametro(parametro);
                prmtVO.getPrvr().setFini(fechaInicio);
                prmtVO.getPrvr().setFfin(fechaFin);

                if (tpprVO.getEntdList() != null) {
                    for (final Long entdId : tpprVO.getEntdList()) {
                        final EntidadTipoDatoVO entdVO = tpprVO.getEntdMap().get(entdId);
                        final Object value = rs.getObject(i++);
                        final ItemDatoVO itdtVO = getItdt(value, entdVO, tpprVO.getNombre());

                        prmtVO.getItdtMap().put(entdVO.getTpdt().getId(), itdtVO);
                    }
                }

                final Map<String, ParametroI18nVO> p18nMap = new HashMap<>();

                if (tpprVO.getI18n()) {
                    final ParametroI18nVO i18nVO = new ParametroI18nVO();
                    final String texto = rs.getString(i++);

                    i18nVO.setIdioma(idioma);
                    i18nVO.setTexto(texto);

                    if (rs.wasNull()) {
                        LOG.warn("Texto i18n NULO para el parametro: " + prmtVO.getParametro() + " del maestro: "
                                + tpprVO.getNombre());

                        i18nVO.setTexto("Texto Generico");

                        // throw new Error("Texto i18n NULO para el parametro: "
                        // + prmtVO.getParametro() + " del maestro: "
                        // + tpprVO.getNombre());
                    }

                    p18nMap.put(idioma, i18nVO);
                }

                try {
                    prmtBO.insert(prmtVO, tpprVO, p18nMap);

                    tpprPrmtMap.get(prmtVO.getEntiId()).put(prmtVO.getParametro(), prmtVO.getId());
                } catch (final DuplicateInstanceException ex) {
                    LOG.info(tpprVO.getNombre() + " Duplicado: " + prmtVO.getEtiqueta());
                }
            }
        } finally {
            DbUtils.closeQuietly(rs);
        }
    }

    /**
     * Import subtipo parametro.
     *
     * @param con
     *            the con
     * @param entidad
     *            the entidad
     * @param isTmpImpl
     *            the is tmp impl
     * @param sql
     *            the sql
     * @throws SQLException
     *             the SQL exception
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    private void importSubtipoParametro(final Connection con, final Entidad entidad, final boolean isTmpImpl,
            final StringBuffer sql) throws SQLException, DuplicateInstanceException {
        final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);
        final TipoSubparametroVO tpspVO = TipoSubparametroProxy.select(entidad.getId());
        final TipoParametroVO tpprPadreVO = TipoParametroProxy.select(tpspVO.getTpprId());

        if (tpspVO == null) {
            throw new Error("No se encuentra el tipo de subparametro con id: " + entidad.getId());
        }

        if (tpspVO.getEntiPadresList() == null || tpspVO.getEntiPadresList().isEmpty()) {
            throw new Error("El tipo de subparametro: " + tpspVO.getEtiqueta() + " no tiene entidades padre");
        }

        ResultSet rs = null;

        try (final PreparedStatement stmt = con.prepareStatement(sql.toString());) {
            int i = 1;

            if (tpspVO.getI18n()) {
                stmt.setString(i++, idioma);
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
            }

            if (isTmpImpl) {
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
            }

            rs = stmt.executeQuery();

            while (rs.next()) {
                i = 1;

                final SubparametroVO sprmVO = SubparametroVO.newInstance(tpspVO);
                final String parametro = rs.getString(i++);
                final String parametroAsociado = rs.getString(i++);
                final Long prmtId = tpprPrmtMap.get(tpspVO.getTpprId()).get(parametro);
                final Long prmtAsociadoId = tpprPrmtMap.get(tpspVO.getTpprAsociado().getId()).get(parametroAsociado);
                final ParametroVO prmtAsociadoVO = new ParametroVO();

                prmtAsociadoVO.setId(prmtAsociadoId);
                sprmVO.setPrmtId(prmtId);
                sprmVO.setPrmtAsociado(prmtAsociadoVO);

                if (tpspVO.getTempExp()) {
                    sprmVO.getSpvr().setFinicio(rs.getDate(i++));
                    sprmVO.getSpvr().setFfin(rs.getDate(i++));
                } else {
                    sprmVO.getSpvr().setFinicio(fechaInicioReferencia);
                    sprmVO.getSpvr().setFfin(null);
                }

                if (tpspVO.getEntdList() != null) {
                    for (final Long entdId : tpspVO.getEntdList()) {
                        final EntidadTipoDatoVO entdVO = tpspVO.getEntdMap().get(entdId);
                        final Object value = rs.getObject(i++);
                        final ItemDatoVO itdtVO = getItdt(value, entdVO, tpspVO.getNombre());

                        sprmVO.getItdtMap().put(entdVO.getTpdt().getId(), itdtVO);
                    }
                }

                if (prmtId == null) {
                    LOG.error("No encontrado parametro: " + parametro + " para la entidad: "
                            + tpprPadreVO.getEtiqueta());
                }

                if (prmtAsociadoId == null) {
                    LOG.error("No encontrado parametro: " + parametroAsociado + " para la entidad: "
                            + tpspVO.getTpprAsociado().getEtiqueta());
                }

                // TODO i18n

                if (sprmVO.getPrmtId() != null && sprmVO.getPrmtAsociado().getId() != null) {
                    try {
                        sprmBO.insert(sprmVO, tpspVO);
                    } catch (final DuplicateInstanceException ex) {
                        LOG.info(tpspVO.getNombre() + " Duplicado: " + sprmVO.getEtiqueta());
                    }
                }
            }
        } finally {
            DbUtils.closeQuietly(rs);
        }
    }

    /**
     * Gets the itdt.
     *
     * @param value
     *            the value
     * @param entdVO
     *            the entd vo
     * @param nombreEntidad
     *            the nombre entidad
     * @return the itdt
     * @throws SQLException
     *             the sQL exception
     */
    private ItemDatoVO getItdt(final Object value, final EntidadTipoDatoVO entdVO, final String nombreEntidad)
            throws SQLException {
        if (value == null && entdVO.getObligatorio()) {
            throw new Error("Campo obligatorio no encontrado para el dato: " + entdVO.getTpdt().getNombre() + " ("
                    + entdVO.getEtiqueta() + ") de la entidad: " + nombreEntidad);
        }

        final ItemDatoVO itdtVO = new ItemDatoVO();

        itdtVO.setTpdtId(entdVO.getTpdt().getId());

        if (value != null) {
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
                    final String message = "Parametro no encontrado para el codigo: " + value + " en el tipo de dato: "
                            + entdVO.getTpdt().getNombre() + " de la entidad: " + nombreEntidad;

                    LOG.warn(message);
                }

                final ParametroVO prmtVO = new ParametroVO();

                prmtVO.setId(prmtId);
                itdtVO.setPrmt(prmtVO);

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
     * @param amaestrosList
     *            the amaestros list
     * @param amaestrosSqlMap
     *            the amaestros sql map
     * @throws ParserConfigurationException
     *             the parser configuration exception
     * @throws SAXException
     *             the sAX exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void parseXml(final List<Entidad> amaestrosList, final Map<Entidad, MaestroNodoVO> amaestrosSqlMap)
            throws ParserConfigurationException, SAXException, IOException {
        LOG.info("Lectura del Archivo XML de consultas de Maestros");

        final SAXParserFactory factory = SAXParserFactory.newInstance();
        final SAXParser saxParser = factory.newSAXParser();

        final DefaultHandler handler = new DefaultHandler() {

            private boolean isSql;

            private Entidad sqlName;

            private boolean tempImp;

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
                    tempImp = Boolean.parseBoolean(attributes.getValue(XML_TEMPIMP_ATTR));
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
                    amaestrosList.add(sqlName);
                    amaestrosSqlMap.put(sqlName, new MaestroNodoVO(sqlName, tempImp, sql));

                    isSql = false;
                }
            }

        };

        saxParser.parse(MaestroImporterBO.class.getResourceAsStream(MAESTRO_FILENAME), handler);
    }
}
