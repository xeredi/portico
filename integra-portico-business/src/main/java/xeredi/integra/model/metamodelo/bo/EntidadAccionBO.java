package xeredi.integra.model.metamodelo.bo;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadAccionDAO;
import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionBO.
 */
public final class EntidadAccionBO {

    /** The enti dao. */
    EntidadDAO entiDAO;

    /** The enac dao. */
    EntidadAccionDAO enacDAO;

    /**
     * Insert.
     *
     * @param enacVO
     *            the enac vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final EntidadAccionVO enacVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(enacVO);
        Preconditions.checkNotNull(enacVO.getEntiId());
        Preconditions.checkNotNull(enacVO.getPath());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            entiDAO = session.getMapper(EntidadDAO.class);
            enacDAO = session.getMapper(EntidadAccionDAO.class);

            if (enacDAO.exists(enacVO)) {
                throw new DuplicateInstanceException(EntidadAccionVO.class.getName(), enacVO);
            }

            enacDAO.insert(enacVO);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param enacVO
     *            the enac vo
     */
    public final void update(final EntidadAccionVO enacVO) {
        Preconditions.checkNotNull(enacVO);
        Preconditions.checkNotNull(enacVO.getEntiId());
        Preconditions.checkNotNull(enacVO.getPath());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            enacDAO = session.getMapper(EntidadAccionDAO.class);

            final int updated = enacDAO.update(enacVO);

            if (updated == 0) {
                throw new Error("Accion de entidad no encontrada: " + enacVO);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param enacVO
     *            the enac vo
     */
    public final void delete(final EntidadAccionVO enacVO) {
        Preconditions.checkNotNull(enacVO);
        Preconditions.checkNotNull(enacVO.getEntiId());
        Preconditions.checkNotNull(enacVO.getPath());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            enacDAO = session.getMapper(EntidadAccionDAO.class);

            final EntidadAccionCriterioVO enacCriterioVO = new EntidadAccionCriterioVO();

            enacCriterioVO.setEntiId(enacVO.getEntiId());
            enacCriterioVO.setPath(enacVO.getPath());

            enacDAO.deleteCriterio(enacCriterioVO);

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param entiId
     *            the enti id
     * @param path
     *            the path
     * @return the entidad accion vo
     */
    public final EntidadAccionVO select(final Long entiId, final String path) {
        Preconditions.checkNotNull(entiId);
        Preconditions.checkNotNull(path);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            enacDAO = session.getMapper(EntidadAccionDAO.class);

            final EntidadAccionCriterioVO enacCriterioVO = new EntidadAccionCriterioVO();

            enacCriterioVO.setEntiId(entiId);
            enacCriterioVO.setPath(path);

            final EntidadAccionVO enacVO = enacDAO.selectObject(enacCriterioVO);

            if (enacVO == null) {
                throw new Error("Accion de entidad no encontrada: " + enacCriterioVO);
            }

            return enacVO;
        }
    }
}
