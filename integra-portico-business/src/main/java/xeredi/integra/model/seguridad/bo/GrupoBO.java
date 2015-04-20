package xeredi.integra.model.seguridad.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.seguridad.dao.AccionDAO;
import xeredi.integra.model.seguridad.dao.GrupoAccionDAO;
import xeredi.integra.model.seguridad.dao.GrupoDAO;
import xeredi.integra.model.seguridad.dao.UsuarioGrupoDAO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.AccionVO;
import xeredi.integra.model.seguridad.vo.GrupoAccionCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoAccionVO;
import xeredi.integra.model.seguridad.vo.GrupoCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoVO;
import xeredi.integra.model.seguridad.vo.UsuarioGrupoCriterioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoBO.
 */
public final class GrupoBO {

    /**
     * Insert.
     *
     * @param grpo
     *            the grpo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final GrupoVO grpo) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoDAO grpoDAO = session.getMapper(GrupoDAO.class);
            final IgBO igBO = new IgBO();

            if (grpoDAO.exists(grpo)) {
                throw new DuplicateInstanceException(MessageI18nKey.grpo, grpo);
            }

            grpo.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            grpoDAO.insert(grpo);

            if (grpo.getAccnIds() != null) {
                final GrupoAccionDAO gracDAO = session.getMapper(GrupoAccionDAO.class);

                for (final Long accnId : grpo.getAccnIds()) {
                    final GrupoAccionVO grac = new GrupoAccionVO(grpo.getId(), accnId);

                    gracDAO.insert(grac);
                }
            }

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param grpo
     *            the grpo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final GrupoVO grpo) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoDAO grpoDAO = session.getMapper(GrupoDAO.class);

            if (grpoDAO.update(grpo) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.grpo, grpo);
            }

            final GrupoAccionDAO gracDAO = session.getMapper(GrupoAccionDAO.class);
            final GrupoAccionCriterioVO gracCriterio = new GrupoAccionCriterioVO();

            gracCriterio.setGrpoId(grpo.getId());

            gracDAO.deleteList(gracCriterio);

            if (grpo.getAccnIds() != null) {
                for (final Long accnId : grpo.getAccnIds()) {
                    final GrupoAccionVO grac = new GrupoAccionVO(grpo.getId(), accnId);

                    gracDAO.insert(grac);
                }
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param grpo
     *            the grpo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final GrupoVO grpo) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoDAO grpoDAO = session.getMapper(GrupoDAO.class);

            if (grpoDAO.delete(grpo) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.grpo, grpo);
            }

            final GrupoAccionDAO gracDAO = session.getMapper(GrupoAccionDAO.class);
            final GrupoAccionCriterioVO gracCriterio = new GrupoAccionCriterioVO();

            gracCriterio.setGrpoId(grpo.getId());

            gracDAO.deleteList(gracCriterio);

            final UsuarioGrupoDAO usgrDAO = session.getMapper(UsuarioGrupoDAO.class);
            final UsuarioGrupoCriterioVO usgrCriterio = new UsuarioGrupoCriterioVO();

            usgrCriterio.setGrpoId(grpo.getId());

            usgrDAO.deleteList(usgrCriterio);

            session.commit();
        }
    }

    /**
     * Select list.
     *
     * @param grpoCriterio
     *            the grpo criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<GrupoVO> selectList(final GrupoCriterioVO grpoCriterio, final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoDAO grpoDAO = session.getMapper(GrupoDAO.class);
            final int count = grpoDAO.count(grpoCriterio);
            final List<GrupoVO> grpoList = new ArrayList<GrupoVO>();

            if (count > offset) {
                grpoList.addAll(grpoDAO.selectList(grpoCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<GrupoVO>(grpoList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param grpoCriterio
     *            the grpo criterio
     * @return the list
     */
    public List<GrupoVO> selectList(final GrupoCriterioVO grpoCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoDAO grpoDAO = session.getMapper(GrupoDAO.class);

            return grpoDAO.selectList(grpoCriterio);
        }
    }

    /**
     * Select object.
     *
     * @param grpoCriterio
     *            the grpo criterio
     * @return the grupo vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public GrupoVO selectObject(final GrupoCriterioVO grpoCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final GrupoDAO grpoDAO = session.getMapper(GrupoDAO.class);
            final GrupoVO grpo = grpoDAO.selectObject(grpoCriterio);

            if (grpo == null) {
                throw new InstanceNotFoundException(MessageI18nKey.grpo, grpoCriterio);
            }

            final Set<Long> accnIds = new HashSet<>();
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);
            final AccionCriterioVO accnCriterio = new AccionCriterioVO();

            accnCriterio.setGrpoId(grpo.getId());

            for (final AccionVO accn : accnDAO.selectList(accnCriterio)) {
                accnIds.add(accn.getId());
            }

            grpo.setAccnIds(accnIds);

            return grpo;
        }
    }
}
