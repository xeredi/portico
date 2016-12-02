package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.AccionEntidadBaseDAO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseVO;
import xeredi.argo.model.util.PaginatedList;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadBaseBO.
 */
public final class AccionEntidadBaseBO {

    /**
     * Insert.
     *
     * @param aebs
     *            the aebs
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(@NonNull final AccionEntidadBaseVO aebs) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionEntidadBaseDAO aebsDAO = session.getMapper(AccionEntidadBaseDAO.class);

            if (aebsDAO.exists(aebs)) {
                throw new DuplicateInstanceException(MessageI18nKey.aebs, aebs);
            }

            IgUtilBO.assignNextVal(aebs);
            aebsDAO.insert(aebs);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param aebs
     *            the aebs
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(@NonNull final AccionEntidadBaseVO aebs) throws InstanceNotFoundException {
        Preconditions.checkNotNull(aebs.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionEntidadBaseDAO aebsDAO = session.getMapper(AccionEntidadBaseDAO.class);

            if (aebsDAO.update(aebs) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.aebs, aebs);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param aebs
     *            the aebs
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(@NonNull final AccionEntidadBaseVO aebs) throws InstanceNotFoundException {
        Preconditions.checkNotNull(aebs.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionEntidadBaseDAO aebsDAO = session.getMapper(AccionEntidadBaseDAO.class);

            if (aebsDAO.delete(aebs) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.aebs, aebs);
            }

            session.commit();
        }
    }

    /**
     * Select list.
     *
     * @param aebsCriterio
     *            the aebs criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<AccionEntidadBaseVO> selectList(@NonNull final AccionEntidadBaseCriterioVO aebsCriterio,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionEntidadBaseDAO aebsDAO = session.getMapper(AccionEntidadBaseDAO.class);
            final int count = aebsDAO.count(aebsCriterio);

            return new PaginatedList<AccionEntidadBaseVO>(
                    count > offset ? aebsDAO.selectList(aebsCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
                    offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param aebsCriterio
     *            the aebs criterio
     * @return the list
     */
    public List<AccionEntidadBaseVO> selectList(@NonNull final AccionEntidadBaseCriterioVO aebsCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionEntidadBaseDAO aebsDAO = session.getMapper(AccionEntidadBaseDAO.class);

            return aebsDAO.selectList(aebsCriterio);
        }
    }

    /**
     * Select object.
     *
     * @param aebsCriterio
     *            the aebs criterio
     * @return the accion entidad base VO
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public AccionEntidadBaseVO selectObject(@NonNull final AccionEntidadBaseCriterioVO aebsCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionEntidadBaseDAO aebsDAO = session.getMapper(AccionEntidadBaseDAO.class);
            final AccionEntidadBaseVO aebs = aebsDAO.selectObject(aebsCriterio);

            if (aebs == null) {
                throw new InstanceNotFoundException(MessageI18nKey.aebs, aebsCriterio);
            }

            return aebs;
        }
    }

}
