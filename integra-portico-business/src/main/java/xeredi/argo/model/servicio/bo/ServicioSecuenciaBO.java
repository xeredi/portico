package xeredi.argo.model.servicio.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.servicio.dao.ServicioSecuenciaDAO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaBO.
 */
public final class ServicioSecuenciaBO {

    /**
     * Insert.
     *
     * @param srsc
     *            the srsc
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final ServicioSecuenciaVO srsc) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioSecuenciaDAO srscDAO = session.getMapper(ServicioSecuenciaDAO.class);

            if (srscDAO.exists(srsc)) {
                throw new DuplicateInstanceException(MessageI18nKey.srsc, srsc);
            }

            srscDAO.insert(srsc);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param srsc
     *            the srsc
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final ServicioSecuenciaVO srsc) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioSecuenciaDAO srscDAO = session.getMapper(ServicioSecuenciaDAO.class);

            if (srscDAO.update(srsc) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.srsc, srsc);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param srsc
     *            the srsc
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final ServicioSecuenciaVO srsc) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioSecuenciaDAO srscDAO = session.getMapper(ServicioSecuenciaDAO.class);

            if (srscDAO.delete(srsc) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.srsc, srsc);
            }

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param srscCriterio
     *            the srsc criterio
     * @return the servicio secuencia vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ServicioSecuenciaVO select(final ServicioSecuenciaCriterioVO srscCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioSecuenciaDAO srscDAO = session.getMapper(ServicioSecuenciaDAO.class);
            final ServicioSecuenciaVO srsc = srscDAO.selectObject(srscCriterio);

            if (srsc == null) {
                throw new InstanceNotFoundException(MessageI18nKey.srsc, srscCriterio);
            }

            return srsc;
        }
    }

    /**
     * Select list.
     *
     * @param srscCriterio
     *            the srsc criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ServicioSecuenciaVO> selectList(final ServicioSecuenciaCriterioVO srscCriterio,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioSecuenciaDAO srscDAO = session.getMapper(ServicioSecuenciaDAO.class);
            final int count = srscDAO.count(srscCriterio);

            return new PaginatedList<>(
                    count > offset ? srscDAO.selectList(srscCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
                    offset, limit, count);
        }
    }
}
