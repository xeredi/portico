package xeredi.argo.model.seguridad.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.dao.AccionDAO;
import xeredi.argo.model.seguridad.dao.GrupoAccionDAO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;
import xeredi.argo.model.seguridad.vo.GrupoAccionCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoAccionVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBO.
 */
public final class AccionBO {

    /**
     * Insert.
     *
     * @param accn
     *            the accn
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull AccionVO accn) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);
            final IgBO igBO = new IgBO();

            if (accnDAO.exists(accn)) {
                throw new DuplicateInstanceException(MessageI18nKey.accn, accn);
            }

            accn.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            accnDAO.insert(accn);

            if (accn.getGrpoIds() != null) {
                final GrupoAccionDAO gracDAO = session.getMapper(GrupoAccionDAO.class);

                for (final Long grpoId : accn.getGrpoIds()) {
                    final GrupoAccionVO grac = new GrupoAccionVO(grpoId, accn.getId());

                    gracDAO.insert(grac);
                }
            }

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param accn
     *            the accn
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull AccionVO accn) throws InstanceNotFoundException {
        Preconditions.checkNotNull(accn.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);

            if (accnDAO.update(accn) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.accn, accn);
            }

            final GrupoAccionDAO gracDAO = session.getMapper(GrupoAccionDAO.class);
            final GrupoAccionCriterioVO gracCriterio = new GrupoAccionCriterioVO();

            gracCriterio.setAccnId(accn.getId());

            gracDAO.deleteList(gracCriterio);

            if (accn.getGrpoIds() != null) {
                for (final Long grpoId : accn.getGrpoIds()) {
                    final GrupoAccionVO grac = new GrupoAccionVO(grpoId, accn.getId());

                    gracDAO.insert(grac);
                }
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param accn
     *            the accn
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull AccionVO accn) throws InstanceNotFoundException {
        Preconditions.checkNotNull(accn.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoAccionDAO gracDAO = session.getMapper(GrupoAccionDAO.class);
            final GrupoAccionCriterioVO gracCriterio = new GrupoAccionCriterioVO();

            gracCriterio.setAccnId(accn.getId());

            gracDAO.deleteList(gracCriterio);

            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);

            if (accnDAO.delete(accn) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.accn, accn);
            }

            session.commit();
        }
    }

    /**
     * Select list.
     *
     * @param accnCriterio
     *            the accn criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<AccionVO> selectList(final @NonNull AccionCriterioVO accnCriterio, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);
            final int count = accnDAO.count(accnCriterio);
            final List<AccionVO> accnList = new ArrayList<AccionVO>();

            if (count > offset) {
                accnList.addAll(accnDAO.selectList(accnCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<AccionVO>(accnList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param accnCriterio
     *            the accn criterio
     * @return the list
     */
    public List<AccionVO> selectList(final @NonNull AccionCriterioVO accnCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);

            return accnDAO.selectList(accnCriterio);
        }
    }

    /**
     * Select object.
     *
     * @param accnCriterio
     *            the accn criterio
     * @return the accion vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public AccionVO selectObject(final @NonNull AccionCriterioVO accnCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);
            final AccionVO accn = accnDAO.selectObject(accnCriterio);

            if (accn == null) {
                throw new InstanceNotFoundException(MessageI18nKey.accn, accnCriterio);
            }

            final GrupoAccionDAO gracDAO = session.getMapper(GrupoAccionDAO.class);
            final GrupoAccionCriterioVO gracCriterio = new GrupoAccionCriterioVO();
            final Set<Long> grpoIds = new HashSet<>();

            gracCriterio.setAccnId(accn.getId());

            for (final GrupoAccionVO grac : gracDAO.selectList(gracCriterio)) {
                grpoIds.add(grac.getGrpoId());
            }

            accn.setGrpoIds(grpoIds);

            return accn;
        }
    }

    /**
     * Exists.
     *
     * @param prefix
     *            the prefix
     * @param codigo
     *            the codigo
     * @param usroId
     *            the usro id
     * @return true, if successful
     */
    public boolean exists(final @NonNull AccionPrefix prefix, final @NonNull String codigo, final @NonNull Long usroId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);
            final AccionCriterioVO accnCriterio = new AccionCriterioVO();

            accnCriterio.setPrefix(prefix);
            accnCriterio.setCodigo(codigo);
            accnCriterio.setUsroId(usroId);

            return accnDAO.count(accnCriterio) == 1;
        }
    }

    /**
     * Exists.
     *
     * @param prefix
     *            the prefix
     * @param codigo
     *            the codigo
     * @param entiId
     *            the enti id
     * @param usroId
     *            the usro id
     * @return true, if successful
     */
    public boolean exists(final @NonNull AccionPrefix prefix, final @NonNull String codigo, final @NonNull Long entiId,
            final @NonNull Long usroId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);
            final AccionCriterioVO accnCriterio = new AccionCriterioVO();

            accnCriterio.setPrefix(prefix);
            accnCriterio.setCodigo(codigo);
            accnCriterio.setEntiId(entiId);
            accnCriterio.setUsroId(usroId);

            return accnDAO.count(accnCriterio) == 1;
        }
    }

}
