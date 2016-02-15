package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.AccionTramiteDAO;
import xeredi.argo.model.metamodelo.vo.AccionTramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionTramiteVO;
import xeredi.argo.model.seguridad.dao.GrupoAccionTramiteDAO;
import xeredi.argo.model.seguridad.vo.GrupoAccionTramiteCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoAccionTramiteVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionTramiteBO.
 */
public final class AccionTramiteBO {

    /**
     * Insert.
     *
     * @param actr
     *            the actr
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull AccionTramiteVO actr) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionTramiteDAO actrDAO = session.getMapper(AccionTramiteDAO.class);
            final IgBO igBO = new IgBO();

            if (actrDAO.exists(actr)) {
                throw new DuplicateInstanceException(MessageI18nKey.actr, actr);
            }

            actr.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            actrDAO.insert(actr);

            if (actr.getGrpoIds() != null) {
                final GrupoAccionTramiteDAO graeDAO = session.getMapper(GrupoAccionTramiteDAO.class);

                for (final Long grpoId : actr.getGrpoIds()) {
                    final GrupoAccionTramiteVO grae = new GrupoAccionTramiteVO(grpoId, actr.getId());

                    graeDAO.insert(grae);
                }
            }

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param actr
     *            the actr
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull AccionTramiteVO actr) throws InstanceNotFoundException {
        Preconditions.checkNotNull(actr.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionTramiteDAO actrDAO = session.getMapper(AccionTramiteDAO.class);

            if (actrDAO.update(actr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.actr, actr);
            }

            final GrupoAccionTramiteDAO graeDAO = session.getMapper(GrupoAccionTramiteDAO.class);
            final GrupoAccionTramiteCriterioVO graeCriterio = new GrupoAccionTramiteCriterioVO();

            graeCriterio.setActrId(actr.getId());

            graeDAO.deleteList(graeCriterio);

            if (actr.getGrpoIds() != null) {
                for (final Long grpoId : actr.getGrpoIds()) {
                    final GrupoAccionTramiteVO grae = new GrupoAccionTramiteVO(grpoId, actr.getId());

                    graeDAO.insert(grae);
                }
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param actr
     *            the actr
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull AccionTramiteVO actr) throws InstanceNotFoundException {
        Preconditions.checkNotNull(actr.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoAccionTramiteDAO graeDAO = session.getMapper(GrupoAccionTramiteDAO.class);
            final GrupoAccionTramiteCriterioVO graeCriterio = new GrupoAccionTramiteCriterioVO();

            graeCriterio.setActrId(actr.getId());

            graeDAO.deleteList(graeCriterio);

            final AccionTramiteDAO actrDAO = session.getMapper(AccionTramiteDAO.class);

            if (actrDAO.delete(actr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.actr, actr);
            }

            session.commit();
        }
    }

    /**
     * Select list.
     *
     * @param actrCriterio
     *            the actr criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<AccionTramiteVO> selectList(final @NonNull AccionTramiteCriterioVO actrCriterio,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionTramiteDAO actrDAO = session.getMapper(AccionTramiteDAO.class);
            final int count = actrDAO.count(actrCriterio);
            final List<AccionTramiteVO> actrList = new ArrayList<AccionTramiteVO>();

            if (count > offset) {
                actrList.addAll(actrDAO.selectList(actrCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<AccionTramiteVO>(actrList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param actrCriterio
     *            the actr criterio
     * @return the list
     */
    public List<AccionTramiteVO> selectList(final @NonNull AccionTramiteCriterioVO actrCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionTramiteDAO actrDAO = session.getMapper(AccionTramiteDAO.class);

            return actrDAO.selectList(actrCriterio);
        }
    }

    /**
     * Select object.
     *
     * @param actrCriterio
     *            the actr criterio
     * @return the accion tramite vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public AccionTramiteVO selectObject(final @NonNull AccionTramiteCriterioVO actrCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionTramiteDAO actrDAO = session.getMapper(AccionTramiteDAO.class);
            final AccionTramiteVO actr = actrDAO.selectObject(actrCriterio);

            if (actr == null) {
                throw new InstanceNotFoundException(MessageI18nKey.actr, actrCriterio);
            }

            final GrupoAccionTramiteDAO graeDAO = session.getMapper(GrupoAccionTramiteDAO.class);
            final GrupoAccionTramiteCriterioVO graeCriterio = new GrupoAccionTramiteCriterioVO();
            final Set<Long> grpoIds = new HashSet<>();

            graeCriterio.setActrId(actr.getId());

            for (final GrupoAccionTramiteVO grae : graeDAO.selectList(graeCriterio)) {
                grpoIds.add(grae.getGrpoId());
            }

            actr.setGrpoIds(grpoIds);

            return actr;
        }
    }

}
