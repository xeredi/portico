package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.TipoParametroDAO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroAdminBO.
 */
public class TipoParametroBO {

    /** The tppr dao. */
    TipoParametroDAO tpprDAO;

    /** The enti dao. */
    EntidadDAO entiDAO;

    /**
     * Select label values.
     *
     * @return the list
     */
    public final List<LabelValueVO> selectLabelValues() {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpprDAO = session.getMapper(TipoParametroDAO.class);

        try {
            final List<LabelValueVO> list = new ArrayList<>();

            for (final TipoParametroVO tppr : tpprDAO.selectList(new TipoParametroCriterioVO())) {
                list.add(new LabelValueVO(tppr.getNombre(), tppr.getId()));
            }

            return list;
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @return the list
     */
    public final List<TipoParametroVO> selectList(final TipoParametroCriterioVO tpprCriterioVO) {
        Preconditions.checkNotNull(tpprCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpprDAO = session.getMapper(TipoParametroDAO.class);

        try {
            return tpprDAO.selectList(tpprCriterioVO);
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<TipoParametroVO> selectList(final TipoParametroCriterioVO tpprCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(tpprCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpprDAO = session.getMapper(TipoParametroDAO.class);

        try {
            final int count = tpprDAO.count(tpprCriterioVO);
            final List<TipoParametroVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpprDAO.selectList(tpprCriterioVO, new RowBounds(offset, limit)));
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
     * @return the tipo parametro vo
     */
    public final TipoParametroVO select(final Long id) {
        Preconditions.checkNotNull(id);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpprDAO = session.getMapper(TipoParametroDAO.class);

        try {
            final TipoParametroVO entiVO = tpprDAO.select(id);

            if (entiVO == null) {
                throw new Error("Tipo de parametro no encontrado: " + id);
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
     * @param tpprVO
     *            the tppr vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final TipoParametroVO tpprVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpprVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpprDAO = session.getMapper(TipoParametroDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final Long id = entiDAO.nextSequence();

            tpprVO.setId(id);
            tpprVO.setTipo(TipoEntidad.P);

            if (entiDAO.exists(tpprVO)) {
                throw new DuplicateInstanceException(TipoParametroVO.class.getName(), tpprVO);
            }

            entiDAO.insert(tpprVO);
            tpprDAO.insert(tpprVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param tpprVO
     *            the tppr vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void update(final TipoParametroVO tpprVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpprVO);
        Preconditions.checkNotNull(tpprVO.getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpprDAO = session.getMapper(TipoParametroDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final int updated = tpprDAO.update(tpprVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoParametroVO.class.getName(), tpprVO);
            }

            entiDAO.update(tpprVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param tpprId
     *            the tppr id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final Long tpprId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpprId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpprDAO = session.getMapper(TipoParametroDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final int updated = tpprDAO.delete(tpprId);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoParametroVO.class.getName(), tpprId);
            }

            entiDAO.delete(tpprId);

            session.commit();
        } finally {
            session.close();
        }
    }
}
