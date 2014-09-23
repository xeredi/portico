package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.TipoServicioDAO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioAdminBO.
 */
public class TipoServicioBO {

    /** The tpsr dao. */
    TipoServicioDAO tpsrDAO;

    /** The enti dao. */
    EntidadDAO entiDAO;

    /**
     * Select label values.
     *
     * @return the list
     */
    public final List<LabelValueVO> selectLabelValues() {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpsrDAO = session.getMapper(TipoServicioDAO.class);

        try {
            return tpsrDAO.selectLabelValues(new TipoServicioCriterioVO());
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @return the list
     */
    public final List<TipoServicioVO> selectList(final TipoServicioCriterioVO tpsrCriterioVO) {
        Preconditions.checkNotNull(tpsrCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpsrDAO = session.getMapper(TipoServicioDAO.class);

        try {
            return tpsrDAO.selectList(tpsrCriterioVO);
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<TipoServicioVO> selectList(final TipoServicioCriterioVO tpsrCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(tpsrCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpsrDAO = session.getMapper(TipoServicioDAO.class);

        try {
            final int count = tpsrDAO.count(tpsrCriterioVO);
            final List<TipoServicioVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpsrDAO.selectList(tpsrCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<>(list, offset, limit, count);
        } finally {
            session.close();
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo servicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final TipoServicioVO select(final Long id) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpsrDAO = session.getMapper(TipoServicioDAO.class);

        try {
            final TipoServicioVO entiVO = tpsrDAO.select(id);

            if (entiVO == null) {
                throw new InstanceNotFoundException(TipoServicioVO.class.getName(), id);
            }

            final EntidadBO entiBO = new EntidadBO();

            entiBO.fillDependencies(entiVO);

            return entiVO;
        } finally {
            session.close();
        }
    }

    /**
     * Insert.
     *
     * @param tpsrVO
     *            the tpsr vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final TipoServicioVO tpsrVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpsrVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpsrDAO = session.getMapper(TipoServicioDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final Long id = entiDAO.nextSequence();

            tpsrVO.setId(id);
            tpsrVO.setTipo(TipoEntidad.T);

            if (entiDAO.exists(tpsrVO)) {
                throw new DuplicateInstanceException(TipoServicioVO.class.getName(), tpsrVO);
            }

            entiDAO.insert(tpsrVO);
            tpsrDAO.insert(tpsrVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param tpsrVO
     *            the tpsr vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void update(final TipoServicioVO tpsrVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpsrVO);
        Preconditions.checkNotNull(tpsrVO.getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpsrDAO = session.getMapper(TipoServicioDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final int updated = tpsrDAO.update(tpsrVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoServicioVO.class.getName(), tpsrVO);
            }

            entiDAO.update(tpsrVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param tpsrId
     *            the tpsr id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final Long tpsrId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpsrId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpsrDAO = session.getMapper(TipoServicioDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final int updated = tpsrDAO.delete(tpsrId);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoServicioVO.class.getName(), tpsrId);
            }

            entiDAO.delete(tpsrId);

            session.commit();
        } finally {
            session.close();
        }
    }

}
