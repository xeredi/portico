package xeredi.argo.db.importer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.I18nVO;
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
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;
import xeredi.argo.model.util.DateUtil;

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
     * {@inheritDoc}
     */
    @Override
    protected String getXmlFilename() {
        return MAESTRO_FILENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareImport(Connection con, SqlSession session) throws SQLException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void importEntity(Connection con, SqlSession session, EntityNodeV2VO entiNode)
            throws SQLException, ClassNotFoundException {
        Preconditions.checkNotNull(entiNode.getId());
        Preconditions.checkNotNull(entiNode.getTable());
        Preconditions.checkNotNull(entiNode.getSql());

        final AbstractEntidadDetailVO entityDetail = EntidadProxy.select(entiNode.getId().getId());

        switch (entityDetail.getEnti().getTipo()) {
        case P:
            importMaster(con, session, entiNode);

            break;
        case B:
            importSubmaster(con, session, entiNode);

            break;
        default:
            throw new Error("Invalid entity type: " + entityDetail.getEnti().getTipo());
        }
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
    private void importMaster(@NonNull final Connection con, @NonNull final SqlSession session,
            @NonNull final EntityNodeV2VO entity) throws SQLException, ClassNotFoundException {
        final TipoParametroDetailVO entityDetail = TipoParametroProxy.select(entity.getId().getId());

        final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
        final ParametroDatoDAO prdtDAO = session.getMapper(ParametroDatoDAO.class);
        final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);

        final Map<Long, Long> translationMap = new HashMap<>();

        try (final PreparedStatement stmt = con.prepareStatement(entity.getSql());) {
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

                    IgUtilBO.assignNextVal(prmt.getVersion());
                    prmtDAO.insertVersion(prmt);
                }

                translationMap.put(oldId, prmt.getId());

                if (prmt.getVersion().getId() != null) {
                    for (final Long tpdtId : entityDetail.getEntdList()) {
                        Object value = null;

                        if (i <= columnCount) {
                            value = rs.getObject(i++);
                        }

                        final ItemDatoVO itdt = createItdt(entity.getId(), entityDetail.getEntdMap().get(tpdtId),
                                value);

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

        // Guardar las traducciones
        createTranslations(con, entity.getTable(), translationMap);
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
    private void importSubmaster(@NonNull final Connection con, @NonNull final SqlSession session,
            final EntityNodeV2VO entity) throws SQLException, ClassNotFoundException {
        final TipoSubparametroDetailVO entityDetail = TipoSubparametroProxy.select(entity.getId().getId());
        final TipoParametroDetailVO tpprDetail = TipoParametroProxy.select(entityDetail.getEnti().getTpprId());

        final SubparametroDAO sprmDAO = session.getMapper(SubparametroDAO.class);
        final SubparametroDatoDAO spdtDAO = session.getMapper(SubparametroDatoDAO.class);

        try (final PreparedStatement stmt = con.prepareStatement(entity.getSql());) {
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
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final MaestroImporterV2BO bo = new MaestroImporterV2BO();

        bo.importEntities("60", Calendar.getInstance().getTime(), "es_ES");
    }

}
