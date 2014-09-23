package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.TipoSubparametroDAO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroBO.
 */
public class TipoSubparametroBO {

    /** The tpsp dao. */
    TipoSubparametroDAO tpspDAO;

    /** The enti dao. */
    EntidadDAO entiDAO;

    /**
     * Select label values.
     *
     * @return the list
     */
    public final List<LabelValueVO> selectLabelValues() {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpspDAO = session.getMapper(TipoSubparametroDAO.class);

        try {
            return tpspDAO.selectLabelValues(new TipoSubparametroCriterioVO());
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param tpspCriterioVO
     *            the tpsp criterio vo
     * @return the list
     */
    public final List<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO) {
        Preconditions.checkNotNull(tpspCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpspDAO = session.getMapper(TipoSubparametroDAO.class);

        try {
            return tpspDAO.selectList(tpspCriterioVO);
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param tpspCriterioVO
     *            the tpsp criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(tpspCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpspDAO = session.getMapper(TipoSubparametroDAO.class);

        try {
            final int count = tpspDAO.count(tpspCriterioVO);
            final List<TipoSubparametroVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpspDAO.selectList(tpspCriterioVO, new RowBounds(offset, limit)));
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
     * @return the tipo subparametro vo
     */
    public final TipoSubparametroVO select(final Long id) {
        Preconditions.checkNotNull(id);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpspDAO = session.getMapper(TipoSubparametroDAO.class);

        try {
            final TipoSubparametroVO entiVO = tpspDAO.select(id);

            if (entiVO == null) {
                throw new Error("Tipo de subparametro no encontrado: " + id);
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
     * @param tpspVO
     *            the tpsp vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final TipoSubparametroVO tpspVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpspVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpspDAO = session.getMapper(TipoSubparametroDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final Long id = entiDAO.nextSequence();

            tpspVO.setId(id);
            tpspVO.setTipo(TipoEntidad.B);

            if (entiDAO.exists(tpspVO)) {
                throw new DuplicateInstanceException(TipoSubparametroVO.class.getName(), tpspVO);
            }

            entiDAO.insert(tpspVO);
            tpspDAO.insert(tpspVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param tpspVO
     *            the tpsp vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void update(final TipoSubparametroVO tpspVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpspVO);
        Preconditions.checkNotNull(tpspVO.getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpspDAO = session.getMapper(TipoSubparametroDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final int updated = tpspDAO.update(tpspVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoSubparametroVO.class.getName(), tpspVO);
            }

            entiDAO.update(tpspVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param tpspId
     *            the tpsp id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final Long tpspId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpspId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpspDAO = session.getMapper(TipoSubparametroDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final int updated = tpspDAO.delete(tpspId);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoSubparametroVO.class.getName(), tpspId);
            }

            entiDAO.delete(tpspId);

            session.commit();
        } finally {
            session.close();
        }
    }

}
