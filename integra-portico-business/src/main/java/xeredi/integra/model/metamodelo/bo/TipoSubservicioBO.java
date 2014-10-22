package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.TipoSubservicioDAO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioAdminBO.
 */
public class TipoSubservicioBO {

    /** The tpss dao. */
    TipoSubservicioDAO tpssDAO;

    /** The enti dao. */
    EntidadDAO entiDAO;

    /**
     * Select label values.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    public final List<LabelValueVO> selectLabelValues(final TipoSubservicioCriterioVO criterioVO) {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpssDAO = session.getMapper(TipoSubservicioDAO.class);

        try {
            final List<LabelValueVO> list = new ArrayList<>();

            for (final TipoSubservicioVO tpss : tpssDAO.selectList(criterioVO)) {
                list.add(new LabelValueVO(tpss.getNombre(), tpss.getId()));
            }

            return list;
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param tpssCriterioVO
     *            the tpss criterio vo
     * @return the list
     */
    public final List<TipoSubservicioVO> selectList(final TipoSubservicioCriterioVO tpssCriterioVO) {
        Preconditions.checkNotNull(tpssCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpssDAO = session.getMapper(TipoSubservicioDAO.class);

        try {
            return tpssDAO.selectList(tpssCriterioVO);
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param tpssCriterioVO
     *            the tpss criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<TipoSubservicioVO> selectList(final TipoSubservicioCriterioVO tpssCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(tpssCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpssDAO = session.getMapper(TipoSubservicioDAO.class);

        try {
            final int count = tpssDAO.count(tpssCriterioVO);
            final List<TipoSubservicioVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpssDAO.selectList(tpssCriterioVO, new RowBounds(offset, limit)));
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
     * @param idioma
     *            the idioma
     * @return the tipo subservicio vo
     */
    public final TipoSubservicioVO select(final Long id, final String idioma) {
        Preconditions.checkNotNull(id);
        Preconditions.checkNotNull(idioma);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpssDAO = session.getMapper(TipoSubservicioDAO.class);

        try {
            final TipoSubservicioCriterioVO entiCriterioVO = new TipoSubservicioCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoSubservicioVO entiVO = tpssDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new Error("Tipo de servicio no encontrado: " + id);
            }

            final EntidadBO entiBO = new EntidadBO();

            entiBO.fillDependencies(entiVO, idioma);

            return entiVO;
        } finally {
            session.close();
        }
    }

    /**
     * Insert.
     *
     * @param tpssVO
     *            the tpss vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final TipoSubservicioVO tpssVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpssVO);
        Preconditions.checkNotNull(tpssVO.getTpsrId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpssDAO = session.getMapper(TipoSubservicioDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final Long id = entiDAO.nextSequence();

            tpssVO.setId(id);
            tpssVO.setTipo(TipoEntidad.P);

            if (entiDAO.exists(tpssVO)) {
                throw new DuplicateInstanceException(TipoSubservicioVO.class.getName(), tpssVO);
            }

            entiDAO.insert(tpssVO);
            tpssDAO.insert(tpssVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param tpssVO
     *            the tpss vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void update(final TipoSubservicioVO tpssVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpssVO);
        Preconditions.checkNotNull(tpssVO.getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpssDAO = session.getMapper(TipoSubservicioDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final int updated = tpssDAO.update(tpssVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoSubservicioVO.class.getName(), tpssVO);
            }

            entiDAO.update(tpssVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param tpssId
     *            the tpss id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final Long tpssId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpssId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpssDAO = session.getMapper(TipoSubservicioDAO.class);
        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final int updated = tpssDAO.delete(tpssId);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoSubservicioVO.class.getName(), tpssId);
            }

            entiDAO.delete(tpssId);

            session.commit();
        } finally {
            session.close();
        }
    }
}
