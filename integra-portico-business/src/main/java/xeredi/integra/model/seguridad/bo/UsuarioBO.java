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
import xeredi.integra.model.seguridad.dao.GrupoDAO;
import xeredi.integra.model.seguridad.dao.UsuarioDAO;
import xeredi.integra.model.seguridad.dao.UsuarioGrupoDAO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoVO;
import xeredi.integra.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.integra.model.seguridad.vo.UsuarioGrupoCriterioVO;
import xeredi.integra.model.seguridad.vo.UsuarioGrupoVO;
import xeredi.integra.model.seguridad.vo.UsuarioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioBO.
 */
public final class UsuarioBO {
    /**
     * Insert.
     *
     * @param usro
     *            the usro
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final UsuarioVO usro) throws DuplicateInstanceException {
        Preconditions.checkNotNull(usro);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);
            final IgBO igBO = new IgBO();

            if (usroDAO.exists(usro)) {
                throw new DuplicateInstanceException(MessageI18nKey.usro, usro);
            }

            usro.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            usroDAO.insert(usro);

            if (usro.getGrpoIds() != null) {
                final UsuarioGrupoDAO usgrDAO = session.getMapper(UsuarioGrupoDAO.class);

                for (final Long grpoId : usro.getGrpoIds()) {
                    final UsuarioGrupoVO usgr = new UsuarioGrupoVO(usro.getId(), grpoId);

                    usgrDAO.insert(usgr);
                }
            }

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param usro
     *            the usro
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final UsuarioVO usro) throws InstanceNotFoundException {
        Preconditions.checkNotNull(usro);
        Preconditions.checkNotNull(usro.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);

            if (usroDAO.update(usro) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.usro, usro);
            }

            final UsuarioGrupoDAO usgrDAO = session.getMapper(UsuarioGrupoDAO.class);
            final UsuarioGrupoCriterioVO usgrCriterio = new UsuarioGrupoCriterioVO();

            usgrCriterio.setUsroId(usro.getId());

            usgrDAO.deleteList(usgrCriterio);

            if (usro.getGrpoIds() != null) {
                for (final Long grpoId : usro.getGrpoIds()) {
                    final UsuarioGrupoVO usgr = new UsuarioGrupoVO(usro.getId(), grpoId);

                    usgrDAO.insert(usgr);
                }
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param usro
     *            the usro
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final UsuarioVO usro) throws InstanceNotFoundException {
        Preconditions.checkNotNull(usro);
        Preconditions.checkNotNull(usro.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioGrupoDAO usgrDAO = session.getMapper(UsuarioGrupoDAO.class);
            final UsuarioGrupoCriterioVO usgrCriterio = new UsuarioGrupoCriterioVO();

            usgrCriterio.setUsroId(usro.getId());

            usgrDAO.deleteList(usgrCriterio);

            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);

            if (usroDAO.delete(usro) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.usro, usro);
            }

            session.commit();
        }
    }

    /**
     * Select list.
     *
     * @param usroCriterio
     *            the usro criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<UsuarioVO> selectList(final UsuarioCriterioVO usroCriterio, final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);
            final int count = usroDAO.count(usroCriterio);
            final List<UsuarioVO> usroList = new ArrayList<UsuarioVO>();

            if (count > offset) {
                usroList.addAll(usroDAO.selectList(usroCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<UsuarioVO>(usroList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param usroCriterio
     *            the usro criterio
     * @return the list
     */
    public List<UsuarioVO> selectList(final UsuarioCriterioVO usroCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);

            return usroDAO.selectList(usroCriterio);
        }
    }

    /**
     * Select object.
     *
     * @param usroCriterio
     *            the usro criterio
     * @return the usuario vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public UsuarioVO selectObject(final UsuarioCriterioVO usroCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);
            final UsuarioVO usro = usroDAO.selectObject(usroCriterio);

            if (usro == null) {
                throw new InstanceNotFoundException(MessageI18nKey.usro, usroCriterio);
            }

            final Set<Long> grpoIds = new HashSet<Long>();
            final GrupoDAO grpoDAO = session.getMapper(GrupoDAO.class);
            final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

            grpoCriterio.setUsroId(usro.getId());

            for (final GrupoVO grpo : grpoDAO.selectList(grpoCriterio)) {
                grpoIds.add(grpo.getId());
            }

            usro.setGrpoIds(grpoIds);

            return usro;
        }
    }

    /**
     * Comprueba si un usuario tiene permiso para realizar una accion.
     *
     * @param usro
     *            the usro
     * @param accnPath
     *            the accn path
     * @return true, if successful
     */
    public boolean tienePermiso(final UsuarioVO usro, final String accnPath) {
        Preconditions.checkNotNull(usro);
        Preconditions.checkNotNull(usro.getId());
        Preconditions.checkNotNull(accnPath);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);
            final AccionCriterioVO accnCriterio = new AccionCriterioVO();

            accnCriterio.setUsroId(usro.getId());
            accnCriterio.setCodigo(accnPath);

            return accnDAO.exists(accnCriterio);
        }
    }

}
