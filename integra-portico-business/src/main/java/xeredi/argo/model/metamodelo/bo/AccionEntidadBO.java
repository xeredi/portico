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
import xeredi.argo.model.metamodelo.dao.AccionEntidadDAO;
import xeredi.argo.model.metamodelo.dao.FuncionalidadDAO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

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
            final FuncionalidadDAO fncdDAO = session.getMapper(FuncionalidadDAO.class);

            if (acenDAO.exists(acen)) {
                throw new DuplicateInstanceException(MessageI18nKey.acen, acen);
            }

            IgUtilBO.assignNextVal(acen);
            fncdDAO.insert(acen);
            acenDAO.insert(acen);

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
            final AccionEntidadDAO acenDAO = session.getMapper(AccionEntidadDAO.class);
            final FuncionalidadDAO fncdDAO = session.getMapper(FuncionalidadDAO.class);
            final FuncionalidadGrupoDAO fngrDAO = session.getMapper(FuncionalidadGrupoDAO.class);

            final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

            fngrCriterio.setFncdId(acen.getId());

            if (acenDAO.delete(acen) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.acen, acen);
            }

            fngrDAO.deleteList(fngrCriterio);
            fncdDAO.delete(acen);

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

            return new PaginatedList<AccionEntidadVO>(
                    count > offset ? acenDAO.selectList(acenCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
                    offset, limit, count);
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
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the accion entidad VO
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public AccionEntidadVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

        acenCriterio.setId(id);
        acenCriterio.setIdioma(idioma);

        return selectObject(acenCriterio);
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

            return acen;
        }
    }
}
