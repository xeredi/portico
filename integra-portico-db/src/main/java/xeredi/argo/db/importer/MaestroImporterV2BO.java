package xeredi.argo.db.importer;

import java.io.IOException;
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.dao.ParametroDAO;
import xeredi.argo.model.maestro.dao.ParametroDatoDAO;
import xeredi.argo.model.maestro.dao.SubparametroDAO;
import xeredi.argo.model.maestro.dao.SubparametroDatoDAO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;
import xeredi.argo.model.util.DateUtil;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class MaestroImporterV2BO.
 */
public final class MaestroImporterV2BO extends EntityImporterBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(MaestroImporterV2BO.class);

    /** The Constant MAESTRO_FILENAME. */
    private static final String MAESTRO_FILENAME = "/xeredi/integra/db/importer/MaestroImporter.v2.xml";

    /**
     * The Enum XmlKeyword.
     */
    enum XmlKeyword {

        /** The id. */
        id,
        /** The table. */
        table,
        /** The imp tmp. */
        tempImp,
        /** The sql. */
        sql
    };

    /** The idioma. */
    private String idioma;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The fecha inicio. */
    private Date fechaInicio;

    /** The prto map. */
    private final Map<String, PuertoVO> prtoMap = new HashMap<>();

    /**
     * Import entities.
     *
     * @param sprtCode
     *            the sprt code
     */
    private void importEntities(final String sprtCode) {
        try {
            idioma = "es_ES";

            final Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);

            fechaVigencia = calendar.getTime();

            calendar.add(Calendar.YEAR, -10);

            fechaInicio = calendar.getTime();

            final List<EntityNodeV2VO> entiList = new ArrayList<>();

            parseXml(entiList);

            final SuperpuertoBO sprtBO = new SuperpuertoBO();
            final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

            sprtCriterio.setCodigo(sprtCode);

            final SuperpuertoVO sprt = sprtBO.selectObject(sprtCriterio);

            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setSprtId(sprt.getId());

            for (final PuertoVO prto : prtoBO.selectList(prtoCriterio)) {
                prtoMap.put(prto.getCodigoCorto(), prto);
            }

            Class.forName(ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_driver));

            try (final Connection con = DriverManager.getConnection(
                    ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_url),
                    ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_username),
                    ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_password));
                    final SqlSession session = SqlMapperLocator.getSqlSessionFactory()
                            .openSession(ExecutorType.REUSE)) {

                con.setAutoCommit(false);

                LOG.info("Delete translations");

                deleteTranslations(con);

                for (final EntityNodeV2VO entity : entiList) {
                    LOG.info("Import entity: " + entity.getId());

                    Preconditions.checkNotNull(entity.getId());
                    Preconditions.checkNotNull(entity.getTable());
                    Preconditions.checkNotNull(entity.getSql());

                    final AbstractEntidadDetailVO entityDetail = EntidadProxy.select(entity.getId().getId());

                    switch (entityDetail.getEnti().getTipo()) {
                    case P:
                        importMaster(con, session, entity);

                        break;
                    case B:
                        importSubmaster(con, session, entity);

                        break;
                    default:
                        throw new Error("Invalid entity type: " + entityDetail.getEnti().getTipo());
                    }

                    con.commit();
                    session.commit();
                }

                deleteTranslations(con);
                con.commit();
            }
        } catch (final InstanceNotFoundException ex) {
            LOG.fatal(ex, ex);
        } catch (final SAXException ex) {
            LOG.fatal(ex, ex);
        } catch (final ParserConfigurationException ex) {
            LOG.fatal(ex, ex);
        } catch (final IOException ex) {
            LOG.fatal(ex, ex);
        } catch (final SQLException ex) {
            LOG.fatal(ex, ex);
        } catch (final ClassNotFoundException ex) {
            LOG.fatal(ex, ex);
        }

        LOG.info("Process finished");
    }

    /**
     * Import master.
     *
     * @param con
     *            the con
     * @param session
     *            the session
     * @param entity
     *            the entity
     * @throws SQLException
     *             the SQL exception
     * @throws ClassNotFoundException
     *             the class not found exception
     */
    private void importMaster(final @NonNull Connection con, final @NonNull SqlSession session,
            final @NonNull EntityNodeV2VO entity) throws SQLException, ClassNotFoundException {
        final TipoParametroDetailVO entityDetail = TipoParametroProxy.select(entity.getId().getId());

        final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
        final ParametroDatoDAO prdtDAO = session.getMapper(ParametroDatoDAO.class);
        final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);

        final PreparedStatement stmt = con.prepareStatement(entity.getSql());

        int i = 1;

        if (entityDetail.getEnti().isI18n()) {
            stmt.setString(i++, idioma);
            stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
            stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
        }

        if (entity.getImplicitTemp()) {
            stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
            stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
        }

        final ResultSet rs = stmt.executeQuery();
        final int columnCount = rs.getMetaData().getColumnCount();

        while (rs.next()) {
            final ParametroVO prmt = new ParametroVO();

            i = 1;

            final Long oldId = rs.getLong(i++);

            prmt.setEntiId(entityDetail.getEnti().getId());

            if (entityDetail.getEnti().getPuerto()) {
                final String codigoPuerto = rs.getString(i++);

                if (!prtoMap.containsKey(codigoPuerto)) {
                    final String mensaje = "Port not found: " + codigoPuerto;

                    LOG.fatal(mensaje);
                    throw new Error(mensaje);
                }

                prmt.setPrto(prtoMap.get(codigoPuerto));
            }

            prmt.setParametro(rs.getString(i++));

            if (entityDetail.getEnti().isTempExp()) {
                final Date fini = rs.getDate(i++);
                final Date ffin = rs.getDate(i++);

                if (fini != null) {
                    DateUtil.truncTime(fini, Calendar.HOUR_OF_DAY);

                    prmt.getVersion().setFini(fini);
                }

                if (ffin != null) {
                    DateUtil.truncTime(ffin, Calendar.HOUR_OF_DAY);

                    prmt.getVersion().setFini(fini);
                }
            } else {
                prmt.getVersion().setFini(fechaInicio);
            }

            if (prmtDAO.exists(prmt)) {
                LOG.debug("Parameter already exists");

                prmt.setId(prmtDAO.selectId(prmt));

                if (prmtDAO.existsOverlap(prmt)) {
                    LOG.warn("Master overlap: " + prmt);
                } else {
                    IgUtilBO.assignNextVal(prmt.getVersion());

                    prmtDAO.insertVersion(prmt);
                }
            } else {
                IgUtilBO.assignNextVal(prmt);
                prmtDAO.insert(prmt);

                insertTranslation(con, entity.getTable(), oldId, prmt.getId());

                IgUtilBO.assignNextVal(prmt.getVersion());
                prmtDAO.insertVersion(prmt);
            }

            if (prmt.getVersion().getId() != null) {
                for (final Long tpdtId : entityDetail.getEntdList()) {
                    Object value = null;

                    if (i <= columnCount) {
                        value = rs.getObject(i++);
                    }

                    final ItemDatoVO itdt = createItdt(entity.getId(), entityDetail.getEntdMap().get(tpdtId), value);

                    itdt.setItemId(prmt.getVersion().getId());

                    prdtDAO.insert(itdt);
                }

                if (entityDetail.getEnti().isI18n()) {
                    final I18nVO i18n = new I18nVO();
                    final String texto = rs.getString(i++);

                    i18n.setExternalId(prmt.getVersion().getId());
                    i18n.setPrefix(ClassPrefix.prvr);
                    i18n.setLanguage(ConfigurationProxy.getString(ConfigurationKey.language_default));
                    i18n.setText(texto);

                    if (rs.wasNull()) {
                        LOG.warn("Texto i18n NULO para el parametro: " + prmt.getParametro() + " del maestro: "
                                + entity.getId());

                        i18n.setText("Texto Generico");
                    }

                    i18nDAO.insert(i18n);
                }
            }
        }
    }

    /**
     * Import submaster.
     *
     * @param con
     *            the con
     * @param session
     *            the session
     * @param entity
     *            the entity
     * @throws SQLException
     *             the SQL exception
     * @throws ClassNotFoundException
     *             the class not found exception
     */
    private void importSubmaster(final @NonNull Connection con, final @NonNull SqlSession session,
            final EntityNodeV2VO entity) throws SQLException, ClassNotFoundException {
        final TipoSubparametroDetailVO entityDetail = TipoSubparametroProxy.select(entity.getId().getId());
        final TipoParametroDetailVO tpprDetail = TipoParametroProxy.select(entityDetail.getEnti().getTpprId());

        final SubparametroDAO sprmDAO = session.getMapper(SubparametroDAO.class);
        final SubparametroDatoDAO spdtDAO = session.getMapper(SubparametroDatoDAO.class);

        final PreparedStatement stmt = con.prepareStatement(entity.getSql());

        int i = 1;

        if (entityDetail.getEnti().isI18n()) {
            stmt.setString(i++, idioma);
            stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
            stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
        }

        if (entity.getImplicitTemp()) {
            stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
            stmt.setDate(i++, new java.sql.Date(fechaVigencia.getTime()));
        }

        final ResultSet rs = stmt.executeQuery();
        final int columnCount = rs.getMetaData().getColumnCount();

        while (rs.next()) {
            final SubparametroVO sprm = new SubparametroVO();

            i = 1;

            sprm.setEntiId(entityDetail.getEnti().getId());

            final Long prmtId = readLong(rs, i++);

            if (prmtId == null) {
                LOG.error("No encontrado parametro para la entidad: " + tpprDetail.getEnti().getCodigo());
            }

            final Long prmtAsociadoId = readLong(rs, i++);

            if (prmtAsociadoId == null) {
                LOG.error("No encontrado parametro para la entidad: " + entityDetail.getEnti().getCodigo());
            }

            if (prmtId != null && prmtAsociadoId != null) {
                sprm.setPrmtId(prmtId);
                sprm.setPrmtAsociado(new ParametroVO());
                sprm.getPrmtAsociado().setId(prmtAsociadoId);

                if (entityDetail.getEnti().isTempExp()) {
                    final Date fini = rs.getDate(i++);
                    final Date ffin = rs.getDate(i++);

                    if (fini != null) {
                        DateUtil.truncTime(fini, Calendar.HOUR_OF_DAY);

                        sprm.getVersion().setFini(fini);
                    }

                    if (ffin != null) {
                        DateUtil.truncTime(ffin, Calendar.HOUR_OF_DAY);

                        sprm.getVersion().setFini(fini);
                    }
                } else {
                    sprm.getVersion().setFini(fechaInicio);
                }

                if (sprmDAO.exists(sprm)) {
                    LOG.debug("Subparameter already exists");

                    sprm.setId(sprmDAO.selectId(sprm));

                    if (sprmDAO.existsOverlap(sprm)) {
                        LOG.warn("Subparameter overlap: " + sprm);
                    } else {
                        IgUtilBO.assignNextVal(sprm.getVersion());

                        sprmDAO.insertVersion(sprm);
                    }
                } else {
                    IgUtilBO.assignNextVal(sprm);
                    sprmDAO.insert(sprm);

                    IgUtilBO.assignNextVal(sprm.getVersion());
                    sprmDAO.insertVersion(sprm);
                }

                if (sprm.getVersion().getId() != null) {
                    for (final Long tpdtId : entityDetail.getEntdList()) {
                        Object value = null;

                        if (i <= columnCount) {
                            value = rs.getObject(i++);
                        }

                        final ItemDatoVO itdt = createItdt(entity.getId(), entityDetail.getEntdMap().get(tpdtId),
                                value);

                        itdt.setItemId(sprm.getVersion().getId());

                        spdtDAO.insert(itdt);
                    }
                }
            }
        }
    }

    /**
     * Parses the xml.
     *
     * @param amaestrosList
     *            the amaestros list
     * @throws ParserConfigurationException
     *             the parser configuration exception
     * @throws SAXException
     *             the SAX exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void parseXml(final List<EntityNodeV2VO> amaestrosList)
            throws ParserConfigurationException, SAXException, IOException {
        LOG.info("Xml parse: " + MAESTRO_FILENAME);

        final SAXParserFactory factory = SAXParserFactory.newInstance();
        final SAXParser saxParser = factory.newSAXParser();

        final DefaultHandler handler = new DefaultHandler() {

            private boolean isSql;

            private Entidad id;

            private String table;

            private boolean impTmp;

            private StringBuffer sql;

            /**
             * {@inheritDoc}
             */
            @Override
            public void startElement(final String uri, final String localName, final String qName,
                    final Attributes attributes) throws SAXException {
                if (XmlKeyword.sql.name().equals(qName)) {
                    isSql = true;

                    id = Entidad.valueOf(attributes.getValue(XmlKeyword.id.name()).toUpperCase());
                    table = String.valueOf(attributes.getValue(XmlKeyword.table.name())).toUpperCase();
                    impTmp = Boolean.parseBoolean(attributes.getValue(XmlKeyword.tempImp.name()));
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
                if (XmlKeyword.sql.name().equals(qName)) {
                    amaestrosList.add(new EntityNodeV2VO(id, table, impTmp, sql.toString()));

                    isSql = false;
                }
            }

        };

        saxParser.parse(MaestroImporterBO.class.getResourceAsStream(MAESTRO_FILENAME), handler);
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final MaestroImporterV2BO bo = new MaestroImporterV2BO();

        bo.importEntities("60");
    }

}
