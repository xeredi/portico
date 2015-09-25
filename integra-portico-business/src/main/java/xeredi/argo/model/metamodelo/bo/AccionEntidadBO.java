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
import xeredi.argo.model.metamodelo.dao.AccionEntidadDAO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.seguridad.dao.GrupoAccionEntidadDAO;
import xeredi.argo.model.seguridad.vo.GrupoAccionEntidadCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoAccionEntidadVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadBO.
 */
public final class AccionEntidadBO {

    /**
     * Insert.
     *
     * @param acen
     *            the acen
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull AccionEntidadVO acen) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionEntidadDAO acenDAO = session.getMapper(AccionEntidadDAO.class);
            final IgBO igBO = new IgBO();

            if (acenDAO.exists(acen)) {
                throw new DuplicateInstanceException(MessageI18nKey.acen, acen);
            }

            acen.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            acenDAO.insert(acen);

            if (acen.getGrpoIds() != null) {
                final GrupoAccionEntidadDAO graeDAO = session.getMapper(GrupoAccionEntidadDAO.class);

                for (final Long grpoId : acen.getGrpoIds()) {
                    final GrupoAccionEntidadVO grae = new GrupoAccionEntidadVO(grpoId, acen.getId());

                    graeDAO.insert(grae);
                }
            }

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param acen
     *            the acen
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull AccionEntidadVO acen) throws InstanceNotFoundException {
        Preconditions.checkNotNull(acen.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionEntidadDAO acenDAO = session.getMapper(AccionEntidadDAO.class);

            if (acenDAO.update(acen) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.acen, acen);
            }

            final GrupoAccionEntidadDAO graeDAO = session.getMapper(GrupoAccionEntidadDAO.class);
            final GrupoAccionEntidadCriterioVO graeCriterio = new GrupoAccionEntidadCriterioVO();

            graeCriterio.setAcenId(acen.getId());

            graeDAO.deleteList(graeCriterio);

            if (acen.getGrpoIds() != null) {
                for (final Long grpoId : acen.getGrpoIds()) {
                    final GrupoAccionEntidadVO grae = new GrupoAccionEntidadVO(grpoId, acen.getId());

                    graeDAO.insert(grae);
                }
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param acen
     *            the acen
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull AccionEntidadVO acen) throws InstanceNotFoundException {
        Preconditions.checkNotNull(acen.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoAccionEntidadDAO graeDAO = session.getMapper(GrupoAccionEntidadDAO.class);
            final GrupoAccionEntidadCriterioVO graeCriterio = new GrupoAccionEntidadCriterioVO();

            graeCriterio.setAcenId(acen.getId());

            graeDAO.deleteList(graeCriterio);

            final AccionEntidadDAO acenDAO = session.getMapper(AccionEntidadDAO.class);

            if (acenDAO.delete(acen) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.acen, acen);
            }

            session.commit();
        }
    }

    /**
     * Select list.
     *
     * @param acenCriterio
     *            the acen criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<AccionEntidadVO> selectList(final @NonNull AccionEntidadCriterioVO acenCriterio,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionEntidadDAO acenDAO = session.getMapper(AccionEntidadDAO.class);
            final int count = acenDAO.count(acenCriterio);
            final List<AccionEntidadVO> acenList = new ArrayList<AccionEntidadVO>();

            if (count > offset) {
                acenList.addAll(acenDAO.selectList(acenCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<AccionEntidadVO>(acenList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param acenCriterio
     *            the acen criterio
     * @return the list
     */
    public List<AccionEntidadVO> selectList(final @NonNull AccionEntidadCriterioVO acenCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionEntidadDAO acenDAO = session.getMapper(AccionEntidadDAO.class);

            return acenDAO.selectList(acenCriterio);
        }
    }

    /**
     * Select object.
     *
     * @param acenCriterio
     *            the acen criterio
     * @return the accion entidad vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public AccionEntidadVO selectObject(final @NonNull AccionEntidadCriterioVO acenCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionEntidadDAO acenDAO = session.getMapper(AccionEntidadDAO.class);
            final AccionEntidadVO acen = acenDAO.selectObject(acenCriterio);

            if (acen == null) {
                throw new InstanceNotFoundException(MessageI18nKey.acen, acenCriterio);
            }

            final GrupoAccionEntidadDAO graeDAO = session.getMapper(GrupoAccionEntidadDAO.class);
            final GrupoAccionEntidadCriterioVO graeCriterio = new GrupoAccionEntidadCriterioVO();
            final Set<Long> grpoIds = new HashSet<>();

            graeCriterio.setAcenId(acen.getId());

            for (final GrupoAccionEntidadVO grae : graeDAO.selectList(graeCriterio)) {
                grpoIds.add(grae.getGrpoId());
            }

            acen.setGrpoIds(grpoIds);

            return acen;
        }
    }
}
