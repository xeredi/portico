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
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    public final List<LabelValueVO> selectLabelValues(final TipoServicioCriterioVO criterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpsrDAO = session.getMapper(TipoServicioDAO.class);

            final List<LabelValueVO> list = new ArrayList<>();

            for (final TipoServicioVO tpsr : tpsrDAO.selectList(criterioVO)) {
                list.add(new LabelValueVO(tpsr.getNombre(), tpsr.getId()));
            }

            return list;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpsrDAO = session.getMapper(TipoServicioDAO.class);

            return tpsrDAO.selectList(tpsrCriterioVO);
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpsrDAO = session.getMapper(TipoServicioDAO.class);

            final int count = tpsrDAO.count(tpsrCriterioVO);
            final List<TipoServicioVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpsrDAO.selectList(tpsrCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<>(list, offset, limit, count);
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
    public final TipoServicioVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);
        Preconditions.checkNotNull(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpsrDAO = session.getMapper(TipoServicioDAO.class);

            final TipoServicioCriterioVO entiCriterioVO = new TipoServicioCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoServicioVO entiVO = tpsrDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new InstanceNotFoundException(TipoServicioVO.class.getName(), id);
            }

            final EntidadBO entiBO = new EntidadBO();

            entiBO.fillDependencies(session, entiVO, idioma);

            return entiVO;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpsrDAO = session.getMapper(TipoServicioDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final Long id = entiDAO.nextSequence();

            tpsrVO.setId(id);
            tpsrVO.setTipo(TipoEntidad.T);

            if (entiDAO.exists(tpsrVO)) {
                throw new DuplicateInstanceException(TipoServicioVO.class.getName(), tpsrVO);
            }

            entiDAO.insert(tpsrVO);
            tpsrDAO.insert(tpsrVO);

            session.commit();
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpsrDAO = session.getMapper(TipoServicioDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final int updated = tpsrDAO.update(tpsrVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoServicioVO.class.getName(), tpsrVO);
            }

            entiDAO.update(tpsrVO);

            session.commit();
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpsrDAO = session.getMapper(TipoServicioDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final int updated = tpsrDAO.delete(tpsrId);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoServicioVO.class.getName(), tpsrId);
            }

            entiDAO.delete(tpsrId);

            session.commit();
        }
    }
}
