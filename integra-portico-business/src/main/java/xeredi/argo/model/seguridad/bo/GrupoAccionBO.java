package xeredi.argo.model.seguridad.bo;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.dao.GrupoAccionDAO;
import xeredi.argo.model.seguridad.vo.GrupoAccionCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoAccionVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionBO.
 */
public final class GrupoAccionBO {

    /**
     * Select.
     *
     * @param grpoId
     *            the grpo id
     * @param accnId
     *            the accn id
     * @return the grupo accion vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public GrupoAccionVO select(final @NonNull Long grpoId, final @NonNull Long accnId)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoAccionDAO gracDAO = session.getMapper(GrupoAccionDAO.class);
            final GrupoAccionCriterioVO gracCriterio = new GrupoAccionCriterioVO();

            gracCriterio.setGrpoId(grpoId);
            gracCriterio.setAccnId(accnId);

            final GrupoAccionVO grac = gracDAO.selectObject(gracCriterio);

            if (grac == null) {
                throw new InstanceNotFoundException(MessageI18nKey.grac, grac);
            }

            return grac;
        }
    }

    /**
     * Insert.
     *
     * @param grpoId
     *            the grpo id
     * @param accnId
     *            the accn id
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull Long grpoId, final @NonNull Long accnId) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoAccionDAO gracDAO = session.getMapper(GrupoAccionDAO.class);
            final GrupoAccionVO grac = new GrupoAccionVO(grpoId, accnId);

            if (gracDAO.exists(grac)) {
                throw new DuplicateInstanceException(MessageI18nKey.grac, grac);
            }

            gracDAO.insert(grac);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param grpoId
     *            the grpo id
     * @param accnId
     *            the accn id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull Long grpoId, final @NonNull Long accnId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoAccionDAO gracDAO = session.getMapper(GrupoAccionDAO.class);
            final GrupoAccionVO grac = new GrupoAccionVO(grpoId, accnId);

            if (gracDAO.delete(grac) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.grac, grac);
            }

            session.commit();
        }
    }
}
