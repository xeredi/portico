package xeredi.argo.model.seguridad.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.dao.GrupoDAO;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.dao.UsuarioGrupoDAO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioGrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioGrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
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
    public void insert(final @NonNull UsuarioVO usro) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);

            if (usroDAO.exists(usro)) {
                throw new DuplicateInstanceException(MessageI18nKey.usro, usro);
            }

            IgUtilBO.assignNextVal(usro);

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
    public void update(final @NonNull UsuarioVO usro) throws InstanceNotFoundException {
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
    public void delete(final @NonNull UsuarioVO usro) throws InstanceNotFoundException {
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
    public PaginatedList<UsuarioVO> selectList(final @NonNull UsuarioCriterioVO usroCriterio, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);
            final int count = usroDAO.count(usroCriterio);

            return new PaginatedList<>(
                    count > offset ? usroDAO.selectList(usroCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
                    offset, limit, count);
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
    public UsuarioVO selectObject(final @NonNull UsuarioCriterioVO usroCriterio) throws InstanceNotFoundException {
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
     * Select object.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the usuario vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public UsuarioVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

        usroCriterio.setId(id);
        usroCriterio.setIdioma(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);
            final UsuarioVO usro = usroDAO.selectObject(usroCriterio);

            if (usro == null) {
                throw new InstanceNotFoundException(MessageI18nKey.usro, id);
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
}
