package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.TipoEstadisticaDAO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaBO.
 */
public class TipoEstadisticaBO {

    /** The tpes dao. */
    TipoEstadisticaDAO tpesDAO;

    /** The enti dao. */
    EntidadDAO entiDAO;

    /**
     * Select label values.
     *
     * @return the list
     */
    public final List<LabelValueVO> selectLabelValues() {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpesDAO = session.getMapper(TipoEstadisticaDAO.class);

            final List<LabelValueVO> list = new ArrayList<>();

            for (final TipoEstadisticaVO tpes : tpesDAO.selectList(new TipoEstadisticaCriterioVO())) {
                list.add(new LabelValueVO(tpes.getNombre(), tpes.getId()));
            }

            return list;
        }
    }

    /**
     * Select list.
     *
     * @param tpesCriterioVO
     *            the tpes criterio vo
     * @return the list
     */
    public final List<TipoEstadisticaVO> selectList(final TipoEstadisticaCriterioVO tpesCriterioVO) {
        Preconditions.checkNotNull(tpesCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpesDAO = session.getMapper(TipoEstadisticaDAO.class);

            return tpesDAO.selectList(tpesCriterioVO);
        }
    }

    /**
     * Select list.
     *
     * @param tpesCriterioVO
     *            the tpes criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<TipoEstadisticaVO> selectList(final TipoEstadisticaCriterioVO tpesCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(tpesCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpesDAO = session.getMapper(TipoEstadisticaDAO.class);

            final int count = tpesDAO.count(tpesCriterioVO);
            final List<TipoEstadisticaVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpesDAO.selectList(tpesCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<>(list, offset, limit, count);
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the tipo estadistica vo
     */
    public final TipoEstadisticaVO select(final Long id, final String idioma) {
        Preconditions.checkNotNull(id);
        Preconditions.checkNotNull(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpesDAO = session.getMapper(TipoEstadisticaDAO.class);

            final TipoEstadisticaCriterioVO entiCriterioVO = new TipoEstadisticaCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoEstadisticaVO entiVO = tpesDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new Error("Tipo de estadistica no encontrado: " + id);
            }

            final EntidadBO entiBO = new EntidadBO();

            entiBO.fillDependencies(session, entiVO, idioma);

            return entiVO;
        }
    }

    /**
     * Insert.
     *
     * @param tpesVO
     *            the tpes vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final TipoEstadisticaVO tpesVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpesVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final Long id = entiDAO.nextSequence();

            tpesVO.setId(id);
            tpesVO.setTipo(TipoEntidad.E);

            if (entiDAO.exists(tpesVO)) {
                throw new DuplicateInstanceException(TipoEstadisticaVO.class.getName(), tpesVO);
            }

            entiDAO.insert(tpesVO);
            tpesDAO.insert(tpesVO);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpesVO
     *            the tpes vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void update(final TipoEstadisticaVO tpesVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpesVO);
        Preconditions.checkNotNull(tpesVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final int updated = entiDAO.update(tpesVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoEstadisticaVO.class.getName(), tpesVO);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param tpesId
     *            the tpes id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final Long tpesId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpesId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final int updated = tpesDAO.delete(tpesId);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoEstadisticaVO.class.getName(), tpesId);
            }

            entiDAO.delete(tpesId);

            session.commit();
        }
    }
}
