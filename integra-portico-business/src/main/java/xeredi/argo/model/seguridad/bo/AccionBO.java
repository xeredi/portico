package xeredi.argo.model.seguridad.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.dao.AccionDAO;
import xeredi.argo.model.seguridad.dao.GrupoAccionDAO;
import xeredi.argo.model.seguridad.dao.GrupoDAO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionVO;
import xeredi.argo.model.seguridad.vo.GrupoAccionCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoAccionVO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
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
    public void update(final AccionVO accn) throws InstanceNotFoundException {
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
    public void delete(final AccionVO accn) throws InstanceNotFoundException {
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

            final Set<Long> grpoIds = new HashSet<>();
            final GrupoDAO grpoDAO = session.getMapper(GrupoDAO.class);
            final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

            grpoCriterio.setAccnId(accn.getId());

            for (final GrupoVO grpo : grpoDAO.selectList(grpoCriterio)) {
                grpoIds.add(grpo.getId());
            }

            accn.setGrpoIds(grpoIds);

            return accn;
        }
    }

}
