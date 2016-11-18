package xeredi.argo.model.metamodelo.bo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.FuncionalidadDAO;
import xeredi.argo.model.metamodelo.dao.TramiteDAO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteBO.
 */
public final class TramiteBO {

    /**
     * Checks if is user allowed.
     *
     * @param trmtId
     *            the trmt id
     * @param usroId
     *            the usro id
     * @return true, if is user allowed
     */
    public boolean isUserAllowed(@NonNull final Long trmtId, @NonNull final Long usroId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteDAO trmtDAO = session.getMapper(TramiteDAO.class);
            final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

            trmtCriterio.setId(trmtId);
            trmtCriterio.setUsroId(usroId);

            return trmtDAO.count(trmtCriterio) > 0;
        }
    }

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<TramiteVO> selectList(@NonNull final TramiteCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteDAO trmtDAO = session.getMapper(TramiteDAO.class);

            return trmtDAO.selectList(criterio);
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the tramite vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TramiteVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteDAO trmtDAO = session.getMapper(TramiteDAO.class);
            final TramiteCriterioVO criterio = new TramiteCriterioVO();

            criterio.setId(id);
            criterio.setIdioma(idioma);

            final TramiteVO trmt = trmtDAO.selectObject(criterio);

            if (trmt == null) {
                throw new InstanceNotFoundException(MessageI18nKey.trmt, id);
            }

            return trmt;
        }
    }

    /**
     * Insert.
     *
     * @param trmt
     *            the trmt
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(@NonNull final TramiteVO trmt, @NonNull final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FuncionalidadDAO fncdDAO = session.getMapper(FuncionalidadDAO.class);
            final TramiteDAO trmtDAO = session.getMapper(TramiteDAO.class);

            if (trmtDAO.exists(trmt)) {
                throw new DuplicateInstanceException(MessageI18nKey.trmt, trmt);
            }

            IgUtilBO.assignNextVal(trmt);
            fncdDAO.insert(trmt);
            trmtDAO.insert(trmt);

            I18nUtilBO.insertMap(session, trmt, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param trmt
     *            the trmt
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(@NonNull final TramiteVO trmt, @NonNull final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(trmt.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteDAO trmtDAO = session.getMapper(TramiteDAO.class);

            if (trmtDAO.update(trmt) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.trmt, trmt.getId());
            }

            I18nUtilBO.updateMap(session, trmt, i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param trmt
     *            the trmt
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(@NonNull final TramiteVO trmt) throws InstanceNotFoundException {
        Preconditions.checkNotNull(trmt.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteDAO trmtDAO = session.getMapper(TramiteDAO.class);
            final FuncionalidadDAO fncdDAO = session.getMapper(FuncionalidadDAO.class);
            final FuncionalidadGrupoDAO fngrDAO = session.getMapper(FuncionalidadGrupoDAO.class);

            if (trmtDAO.delete(trmt) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.trmt, trmt);
            }

            final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

            fngrCriterio.setFncdId(trmt.getId());

            fngrDAO.deleteList(fngrCriterio);
            fncdDAO.delete(trmt);

            I18nUtilBO.deleteMap(session, trmt);

            session.commit();
        }
    }

}
