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
import xeredi.argo.model.metamodelo.dao.AccionBaseDAO;
import xeredi.argo.model.metamodelo.dao.FuncionalidadDAO;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseBO.
 */
public final class AccionBaseBO {
    /**
     * Insert.
     *
     * @param acbs
     *            the acbs
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull AccionBaseVO acbs) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionBaseDAO acbsDAO = session.getMapper(AccionBaseDAO.class);
            final FuncionalidadDAO fncdDAO = session.getMapper(FuncionalidadDAO.class);

            if (acbsDAO.exists(acbs)) {
                throw new DuplicateInstanceException(MessageI18nKey.acbs, acbs);
            }

            IgUtilBO.assignNextVal(acbs);
            fncdDAO.insert(acbs);
            acbsDAO.insert(acbs);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param acbs
     *            the acbs
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull AccionBaseVO acbs) throws InstanceNotFoundException {
        Preconditions.checkNotNull(acbs.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionBaseDAO acbsDAO = session.getMapper(AccionBaseDAO.class);

            if (acbsDAO.update(acbs) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.acbs, acbs);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param acbs
     *            the acbs
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull AccionBaseVO acbs) throws InstanceNotFoundException {
        Preconditions.checkNotNull(acbs.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionBaseDAO acbsDAO = session.getMapper(AccionBaseDAO.class);
            final FuncionalidadDAO fncdDAO = session.getMapper(FuncionalidadDAO.class);
            final FuncionalidadGrupoDAO fngrDAO = session.getMapper(FuncionalidadGrupoDAO.class);

            final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

            fngrCriterio.setFncdId(acbs.getId());

            if (acbsDAO.delete(acbs) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.acbs, acbs);
            }

            fngrDAO.deleteList(fngrCriterio);
            fncdDAO.delete(acbs);

            session.commit();
        }
    }

    /**
     * Select list.
     *
     * @param acbsCriterio
     *            the acbs criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<AccionBaseVO> selectList(final @NonNull AccionBaseCriterioVO acbsCriterio, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionBaseDAO acbsDAO = session.getMapper(AccionBaseDAO.class);
            final int count = acbsDAO.count(acbsCriterio);

            return new PaginatedList<AccionBaseVO>((count > offset)
                    ? acbsDAO.selectList(acbsCriterio, new RowBounds(offset, limit)) : new ArrayList<>(), offset, limit,
                    count);
        }
    }

    /**
     * Select list.
     *
     * @param acbsCriterio
     *            the acbs criterio
     * @return the list
     */
    public List<AccionBaseVO> selectList(final @NonNull AccionBaseCriterioVO acbsCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionBaseDAO acbsDAO = session.getMapper(AccionBaseDAO.class);

            return acbsDAO.selectList(acbsCriterio);
        }
    }

    /**
     * Select object.
     *
     * @param acbsCriterio
     *            the acbs criterio
     * @return the accion base VO
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public AccionBaseVO selectObject(final @NonNull AccionBaseCriterioVO acbsCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionBaseDAO acbsDAO = session.getMapper(AccionBaseDAO.class);
            final AccionBaseVO acbs = acbsDAO.selectObject(acbsCriterio);

            if (acbs == null) {
                throw new InstanceNotFoundException(MessageI18nKey.acbs, acbsCriterio);
            }

            return acbs;
        }
    }

}
