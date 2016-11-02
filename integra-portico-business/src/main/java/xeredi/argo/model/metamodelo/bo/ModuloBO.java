package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.FuncionalidadDAO;
import xeredi.argo.model.metamodelo.dao.ModuloDAO;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloBO.
 */
public final class ModuloBO {

    /**
     * Checks if is user allowed.
     *
     * @param mdloId
     *            the mdlo id
     * @param usroId
     *            the usro id
     * @return true, if is user allowed
     */
    public boolean isUserAllowed(final @NonNull Long mdloId, final @NonNull Long usroId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ModuloDAO mdloDAO = session.getMapper(ModuloDAO.class);
            final ModuloCriterioVO mdloCriterio = new ModuloCriterioVO();

            mdloCriterio.setId(mdloId);
            mdloCriterio.setUsroId(usroId);

            return mdloDAO.count(mdloCriterio) > 0;
        }
    }

    /**
     * Insert.
     *
     * @param mdlo
     *            the mdlo
     * @param i18nMap
     *            the i 18 n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull ModuloVO mdlo, final @NonNull Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ModuloDAO mdloDAO = session.getMapper(ModuloDAO.class);
            final FuncionalidadDAO fncdDAO = session.getMapper(FuncionalidadDAO.class);
            final IgBO igBO = new IgBO();

            if (mdloDAO.exists(mdlo)) {
                throw new DuplicateInstanceException(MessageI18nKey.mdlo, mdlo);
            }

            igBO.assignNextVal(mdlo);
            fncdDAO.insert(mdlo);
            mdloDAO.insert(mdlo);

            I18nUtilBO.insertMap(session, mdlo, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param mdlo
     *            the mdlo
     * @param i18nMap
     *            the i 18 n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull ModuloVO mdlo, final @NonNull Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(mdlo.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ModuloDAO mdloDAO = session.getMapper(ModuloDAO.class);

            if (mdloDAO.update(mdlo) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.mdlo, mdlo);
            }

            I18nUtilBO.updateMap(session, mdlo, i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param mdlo
     *            the mdlo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull ModuloVO mdlo) throws InstanceNotFoundException {
        Preconditions.checkNotNull(mdlo.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ModuloDAO mdloDAO = session.getMapper(ModuloDAO.class);
            final FuncionalidadDAO fncdDAO = session.getMapper(FuncionalidadDAO.class);
            final FuncionalidadGrupoDAO fngrDAO = session.getMapper(FuncionalidadGrupoDAO.class);

            final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

            fngrCriterio.setFncdId(mdlo.getId());

            if (mdloDAO.delete(mdlo) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.mdlo, mdlo);
            }

            I18nUtilBO.deleteMap(session, mdlo);

            fngrDAO.deleteList(fngrCriterio);
            fncdDAO.delete(mdlo);

            session.commit();
        }
    }

    /**
     * Select list.
     *
     * @param mdloCriterio
     *            the mdlo criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ModuloVO> selectList(final @NonNull ModuloCriterioVO mdloCriterio, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ModuloDAO mdloDAO = session.getMapper(ModuloDAO.class);
            final int count = mdloDAO.count(mdloCriterio);

            final List<ModuloVO> mdloList = (count > offset)
                    ? mdloDAO.selectList(mdloCriterio, new RowBounds(offset, limit)) : new ArrayList<>();

            return new PaginatedList<ModuloVO>(mdloList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param mdloCriterio
     *            the mdlo criterio
     * @return the list
     */
    public List<ModuloVO> selectList(final @NonNull ModuloCriterioVO mdloCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ModuloDAO mdloDAO = session.getMapper(ModuloDAO.class);

            return mdloDAO.selectList(mdloCriterio);
        }
    }

    /**
     * Select object.
     *
     * @param mdloCriterio
     *            the mdlo criterio
     * @return the modulo VO
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ModuloVO selectObject(final @NonNull ModuloCriterioVO mdloCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ModuloDAO mdloDAO = session.getMapper(ModuloDAO.class);
            final ModuloVO mdlo = mdloDAO.selectObject(mdloCriterio);

            if (mdlo == null) {
                throw new InstanceNotFoundException(MessageI18nKey.mdlo, mdloCriterio);
            }

            return mdlo;
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the modulo VO
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ModuloVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        final ModuloCriterioVO mdloCriterio = new ModuloCriterioVO();

        mdloCriterio.setId(id);
        mdloCriterio.setIdioma(idioma);

        return selectObject(mdloCriterio);
    }

}
