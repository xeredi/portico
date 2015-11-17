package xeredi.argo.db.importer;

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
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

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
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.proxy.PorticoResourceBundle;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.bo.SubparametroBO;
import xeredi.argo.model.maestro.bo.SubparametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.maestro.vo.ParametroVersionVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.maestro.vo.SubparametroVersionVO;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;
import xeredi.util.exception.DuplicateInstanceException;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroImporter2BO.
 */
public final class MaestroImporterBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(MaestroImporterBO.class);

    /** The bundle. */
    private static ResourceBundle bundle;

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
     * The fecha vigencia. La que se toma como referencia para traer los datos vigentes a esa fecha en
     * INTEGRA.
     */
    private final Date fechaVigencia;

    /**
     * Fecha que se utiliza para marcar la fecha de inicio de las versiones de los parametros con temporalidad
     * implicita en la BD.
     */
    private final Date fechaInicioReferencia;

    /** The maestros list. */
    private final List<MaestroNodoVO> maestrosList = new ArrayList<>();

    /** The prmt map. */
    private final Map<Long, Map<String, Long>> tpprPrmtMap = new HashMap<>();

    /** The prto map. */
    private final Map<String, PuertoVO> prtoMap = new HashMap<>();

    /**
     * Instantiates a new parametro importer2 bo.
     *
     * @param alocale
     *            the alocale
     * @param afechaVigencia
     *            the afecha vigencia
     */
    public MaestroImporterBO(final Locale alocale, final Date afechaVigencia) {
        super();
        idioma = alocale.getLanguage() + "_" + alocale.getCountry();
        fechaVigencia = afechaVigencia;

        final Calendar calendar = Calendar.getInstance();

        calendar.setTime(afechaVigencia);
        calendar.add(Calendar.YEAR, -10);

        fechaInicioReferencia = calendar.getTime();

        bundle = PorticoResourceBundle.getBundle(alocale);
    }

    /**
     * Import entities.
     */
    public void importEntities() {
        LOG.info("Importacion de maestros");

        try {
            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            for (final PuertoVO prto : prtoBO.selectList(prtoCriterio)) {
                prtoMap.put(prto.getCodigoCorto(), prto);
            }

            Class.forName(ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_driver));

            try (final Connection con = DriverManager.getConnection(
                    ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_url),
                    ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_username),
                    ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_password));) {

                parseXml(maestrosList);

                for (final MaestroNodoVO maestroVO : maestrosList) {
                    final AbstractEntidadDetailVO entiDetail = EntidadProxy.select(maestroVO.getEntidad().getId());
                    final String entiName = bundle.getString(I18nPrefix.enti.name() + "_"
                            + entiDetail.getEnti().getId());

                    switch (entiDetail.getEnti().getTipo()) {
                    case P:
                        if (LOG.isInfoEnabled()) {
                            LOG.info("Importacion del maestro: " + entiName);
                        }

                        importTipoParametro(con, maestroVO.getEntidad(), maestroVO.isTempImp(), maestroVO.getSqlQuery());

                        break;

                    case B:
                        if (LOG.isInfoEnabled()) {
                            LOG.info("Importacion del submaestro: " + entiName);
                        }

                        importSubtipoParametro(con, maestroVO.getEntidad(), maestroVO.isTempImp(),
                                maestroVO.getSqlQuery());

                        break;

                    default:
                        throw new Error("Tipo de entidad: " + entiDetail.getEnti().getTipo()
                                + " no valida para la entidad " + entiName);
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
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    private void importTipoParametro(final Connection con, final Entidad entidad, final boolean isTmpImpl,
            final StringBuffer sql) throws SQLException, DuplicateInstanceException, InstanceNotFoundException {
        final TipoParametroDetailVO tpprDetail = TipoParametroProxy.select(entidad.getId());
        final ParametroBO prmtBO = ParametroBOFactory.newInstance(entidad.getId());
        final String entiName = bundle.getString(I18nPrefix.enti.name() + "_" + tpprDetail.getEnti().getId());

        if (!tpprPrmtMap.containsKey(tpprDetail.getEnti().getId())) {
            tpprPrmtMap.put(tpprDetail.getEnti().getId(), new HashMap<String, Long>());
        }

        ResultSet rs = null;

        try (final PreparedStatement stmt = con.prepareStatement(sql.toString());) {
            int i = 1;

            if (tpprDetail.getEnti().isI18n()) {
                stmt.setString(i++, idioma);
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
            }

            if (isTmpImpl) {
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
                stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
            }

            rs = stmt.executeQuery();

            final int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                i = 1;

                final ParametroVO prmtVO = new ParametroVO();

                prmtVO.setEntiId(tpprDetail.getEnti().getId());
                prmtVO.setVersion(new ParametroVersionVO());

                if (tpprDetail.getEnti().isPuerto()) {
                    final String codigoPuerto = rs.getString(i++);

                    if (!prtoMap.containsKey(codigoPuerto)) {
                        final String mensaje = "Puerto " + codigoPuerto + " no encontrado";

                        LOG.fatal(mensaje);
                        throw new Error(mensaje);
                    }

                    prmtVO.setPrto(prtoMap.get(codigoPuerto));
                }

                prmtVO.setParametro(rs.getString(i++));

                if (tpprDetail.getEnti().isTempExp()) {
                    prmtVO.getVersion().setFini(rs.getDate(i++));
                    prmtVO.getVersion().setFfin(rs.getDate(i++));
                } else {
                    prmtVO.getVersion().setFini(fechaInicioReferencia);
                }

                // Creacion del parametro
                if (tpprDetail.getEntdList() != null) {
                    prmtVO.setItdtMap(new HashMap<Long, ItemDatoVO>());

                    for (final Long tpdtId : tpprDetail.getEntdList()) {
                        final EntidadTipoDatoVO entd = tpprDetail.getEntdMap().get(tpdtId);
                        Object value = null;

                        if (i <= columnCount) {
                            value = rs.getObject(i++);
                        }

                        final ItemDatoVO itdt = getItdt(value, entd, entiName);

                        prmtVO.getItdtMap().put(entd.getTpdt().getId(), itdt);
                    }
                }

                final Map<String, I18nVO> i18nMap = new HashMap<>();

                if (tpprDetail.getEnti().isI18n()) {
                    final I18nVO i18nVO = new I18nVO();
                    final String texto = rs.getString(i++);

                    i18nVO.setPrefix(I18nPrefix.prvr);
                    i18nVO.setLanguage(ConfigurationProxy.getString(ConfigurationKey.language_default));
                    i18nVO.setText(texto);

                    if (rs.wasNull()) {
                        LOG.warn("Texto i18n NULO para el parametro: " + prmtVO.getParametro() + " del maestro: "
                                + entiName);

                        i18nVO.setText("Texto Generico");
                    }

                    i18nMap.put(i18nVO.getLanguage(), i18nVO);
                }

                try {
                    prmtBO.insert(prmtVO, tpprDetail, i18nMap);

                    final String prmtKey = (prmtVO.getPrto() == null ? "" : prmtVO.getPrto().getCodigoCorto())
                            + prmtVO.getParametro();

                    tpprPrmtMap.get(prmtVO.getEntiId()).put(prmtKey, prmtVO.getId());
                } catch (final OverlapException ex) {
                    LOG.info(entiName + " Solapado: " + prmtVO.getEtiqueta());
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
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    private void importSubtipoParametro(final Connection con, final Entidad entidad, final boolean isTmpImpl,
            final StringBuffer sql) throws SQLException, DuplicateInstanceException, InstanceNotFoundException {
        final SubparametroBO sprmBO = SubparametroBOFactory.newDefaultInstance();
        final TipoSubparametroDetailVO tpspDetail = TipoSubparametroProxy.select(entidad.getId());
        final TipoParametroDetailVO tpprPadreDetail = TipoParametroProxy.select(tpspDetail.getEnti().getTpprId());
        final String entiName = bundle.getString(I18nPrefix.enti.name() + "_" + tpspDetail.getEnti().getId());
        final String entiAsociadaName = bundle.getString(I18nPrefix.enti.name() + "_"
                + tpspDetail.getEnti().getTpprAsociado().getId());
        final String entiPadreName = bundle.getString(I18nPrefix.enti.name() + "_" + tpprPadreDetail.getEnti().getId());

        if (tpspDetail.getEntiPadresList() == null || tpspDetail.getEntiPadresList().isEmpty()) {
            throw new Error("El tipo de subparametro: " + entiName + " no tiene entidades padre");
        }

        ResultSet rs = null;

        try (final PreparedStatement stmt = con.prepareStatement(sql.toString());) {
            int i = 1;

            if (tpspDetail.getEnti().isI18n()) {
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

                final SubparametroVO sprmVO = new SubparametroVO();
                final String parametro = rs.getString(i++);
                final String parametroAsociado = rs.getString(i++);
                final Long prmtId = tpprPrmtMap.get(tpspDetail.getEnti().getTpprId()).get(parametro);
                final Long prmtAsociadoId = tpprPrmtMap.get(tpspDetail.getEnti().getTpprAsociado().getId()).get(
                        parametroAsociado);

                if (prmtId == null) {
                    LOG.error("No encontrado parametro: " + parametro + " para la entidad: " + entiPadreName);
                }

                if (prmtAsociadoId == null) {
                    LOG.error("No encontrado parametro: " + parametroAsociado + " para la entidad: " + entiAsociadaName);
                }

                final ParametroVO prmtAsociadoVO = new ParametroVO();

                prmtAsociadoVO.setId(prmtAsociadoId);
                sprmVO.setPrmtId(prmtId);
                sprmVO.setPrmtAsociado(prmtAsociadoVO);
                sprmVO.setEntiId(tpspDetail.getEnti().getId());

                sprmVO.setVersion(new SubparametroVersionVO());

                if (tpspDetail.getEnti().isTempExp()) {
                    sprmVO.getVersion().setFini(rs.getDate(i++));
                    sprmVO.getVersion().setFfin(rs.getDate(i++));
                } else {
                    sprmVO.getVersion().setFini(fechaInicioReferencia);
                    sprmVO.getVersion().setFfin(null);
                }

                if (tpspDetail.getEntdList() != null) {
                    sprmVO.setItdtMap(new HashMap<Long, ItemDatoVO>());

                    for (final Long tpdtId : tpspDetail.getEntdList()) {
                        final EntidadTipoDatoVO entd = tpspDetail.getEntdMap().get(tpdtId);
                        final Object value = rs.getObject(i++);
                        final ItemDatoVO itdt = getItdt(value, entd, entiName);

                        sprmVO.getItdtMap().put(entd.getTpdt().getId(), itdt);
                    }
                }

                // TODO i18n

                if (sprmVO.getPrmtId() != null && sprmVO.getPrmtAsociado().getId() != null) {
                    try {
                        sprmBO.insert(sprmVO, tpspDetail);
                    } catch (final OverlapException ex) {
                        LOG.info(entiName + " Solapado: " + sprmVO.getEtiqueta());
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
        final ItemDatoVO itdtVO = new ItemDatoVO();

        try {
            if (value == null && entdVO.getObligatorio()) {
                throw new Error("Campo obligatorio no encontrado para el dato: " + entdVO.getTpdt().getCodigo() + " ("
                        + entdVO.getEtiqueta() + ") de la entidad: " + nombreEntidad);
            }

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
                        final String message = "Parametro no encontrado para el codigo: " + value
                                + " en el tipo de dato: " + entdVO.getTpdt().getCodigo() + " de la entidad: "
                                + nombreEntidad;

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
        } catch (final Throwable ex) {
            LOG.fatal("Error leyendo itdt");
            LOG.fatal("Entidad: " + nombreEntidad);
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
     * @param amaestrosList
     *            the amaestros list
     * @throws ParserConfigurationException
     *             the parser configuration exception
     * @throws SAXException
     *             the sAX exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void parseXml(final List<MaestroNodoVO> amaestrosList) throws ParserConfigurationException, SAXException,
            IOException {
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
                    amaestrosList.add(new MaestroNodoVO(sqlName, tempImp, sql));

                    isSql = false;
                }
            }

        };

        saxParser.parse(MaestroImporterBO.class.getResourceAsStream(MAESTRO_FILENAME), handler);
    }
}
