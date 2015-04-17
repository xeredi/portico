package xeredi.integra.model.seguridad.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.seguridad.dao.AccionDAO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.AccionVO;
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
    public void insert(final AccionVO accn) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);
            final IgBO igBO = new IgBO();

            if (accnDAO.exists(accn)) {
                throw new DuplicateInstanceException(MessageI18nKey.accn, accn);
            }

            accn.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            accnDAO.insert(accn);

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
    public void update(final AccionVO accn) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);

            if (accnDAO.update(accn) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.accn, accn);
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
    public void delete(final AccionVO accn) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
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
    public PaginatedList<AccionVO> selectList(final AccionCriterioVO accnCriterio, final int offset, final int limit) {
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
    public List<AccionVO> selectList(final AccionCriterioVO accnCriterio) {
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
    public AccionVO selectObject(final AccionCriterioVO accnCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);
            final AccionVO accn = accnDAO.selectObject(accnCriterio);

            if (accn == null) {
                throw new InstanceNotFoundException(MessageI18nKey.accn, accnCriterio);
            }

            return accn;
        }
    }

}
