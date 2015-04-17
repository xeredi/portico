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
import xeredi.integra.model.seguridad.dao.UsuarioDAO;
import xeredi.integra.model.seguridad.dao.UsuarioGrupoDAO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoVO;
import xeredi.integra.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.integra.model.seguridad.vo.UsuarioGrupoVO;
import xeredi.integra.model.seguridad.vo.UsuarioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);
            final IgBO igBO = new IgBO();

            if (usroDAO.exists(usro)) {
                throw new DuplicateInstanceException(MessageI18nKey.usro, usro);
            }

            usro.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            usroDAO.insert(usro);

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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);

            if (usroDAO.update(usro) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.usro, usro);
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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
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

            return usro;
        }
    }

    /**
     * Adds the grupo.
     *
     * @param usro
     *            the usro
     * @param grpo
     *            the grpo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void addGrupo(final UsuarioVO usro, final GrupoVO grpo) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioGrupoDAO usgrDAO = session.getMapper(UsuarioGrupoDAO.class);
            final UsuarioGrupoVO usgr = new UsuarioGrupoVO(usro.getId(), grpo.getId());

            if (usgrDAO.exists(usgr)) {
                throw new DuplicateInstanceException(MessageI18nKey.usgr, usgr);
            }

            usgrDAO.insert(usgr);

            session.commit();
        }
    }

    /**
     * Removes the grupo.
     *
     * @param usro
     *            the usro
     * @param grpo
     *            the grpo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void removeGrupo(final UsuarioVO usro, final GrupoVO grpo) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioGrupoDAO usgrDAO = session.getMapper(UsuarioGrupoDAO.class);
            final UsuarioGrupoVO usgr = new UsuarioGrupoVO(usro.getId(), grpo.getId());

            if (usgrDAO.delete(usgr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.usgr, usgr);
            }

            session.commit();
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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);
            final AccionCriterioVO accnCriterio = new AccionCriterioVO();

            accnCriterio.setUsroId(usro.getId());
            accnCriterio.setCodigo(accnPath);

            return accnDAO.exists(accnCriterio);
        }
    }

}
