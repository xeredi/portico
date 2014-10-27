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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpprDAO = session.getMapper(TipoParametroDAO.class);

            final List<LabelValueVO> list = new ArrayList<>();

            for (final TipoParametroVO tppr : tpprDAO.selectList(new TipoParametroCriterioVO())) {
                list.add(new LabelValueVO(tppr.getNombre(), tppr.getId()));
            }

            return list;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpprDAO = session.getMapper(TipoParametroDAO.class);

            return tpprDAO.selectList(tpprCriterioVO);
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpprDAO = session.getMapper(TipoParametroDAO.class);

            final int count = tpprDAO.count(tpprCriterioVO);
            final List<TipoParametroVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpprDAO.selectList(tpprCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<>(list, offset, limit, count);
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo parametro vo
     */
    public final TipoParametroVO select(final Long id, final String idioma) {
        Preconditions.checkNotNull(id);
        Preconditions.checkNotNull(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpprDAO = session.getMapper(TipoParametroDAO.class);

            final TipoParametroCriterioVO entiCriterioVO = new TipoParametroCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoParametroVO entiVO = tpprDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new Error("Tipo de parametro no encontrado: " + id);
            }

            final EntidadBO entiBO = new EntidadBO();

            entiBO.fillDependencies(session, entiVO, idioma);

            return entiVO;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpprDAO = session.getMapper(TipoParametroDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final Long id = entiDAO.nextSequence();

            tpprVO.setId(id);
            tpprVO.setTipo(TipoEntidad.P);

            if (entiDAO.exists(tpprVO)) {
                throw new DuplicateInstanceException(TipoParametroVO.class.getName(), tpprVO);
            }

            entiDAO.insert(tpprVO);
            tpprDAO.insert(tpprVO);

            session.commit();
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpprDAO = session.getMapper(TipoParametroDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final int updated = tpprDAO.update(tpprVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoParametroVO.class.getName(), tpprVO);
            }

            entiDAO.update(tpprVO);

            session.commit();
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpprDAO = session.getMapper(TipoParametroDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final int updated = tpprDAO.delete(tpprId);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoParametroVO.class.getName(), tpprId);
            }

            entiDAO.delete(tpprId);

            session.commit();
        }
    }
}
