package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpssDAO = session.getMapper(TipoSubservicioDAO.class);

            final List<LabelValueVO> list = new ArrayList<>();

            for (final TipoSubservicioVO tpss : tpssDAO.selectList(criterioVO)) {
                list.add(new LabelValueVO(tpss.getNombre(), tpss.getId()));
            }

            return list;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpssDAO = session.getMapper(TipoSubservicioDAO.class);

            return tpssDAO.selectList(tpssCriterioVO);
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpssDAO = session.getMapper(TipoSubservicioDAO.class);

            final int count = tpssDAO.count(tpssCriterioVO);
            final List<TipoSubservicioVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpssDAO.selectList(tpssCriterioVO, new RowBounds(offset, limit)));
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
     * @return the tipo subservicio vo
     */
    public final TipoSubservicioVO select(final Long id, final String idioma) {
        Preconditions.checkNotNull(id);
        Preconditions.checkNotNull(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpssDAO = session.getMapper(TipoSubservicioDAO.class);

            final TipoSubservicioCriterioVO entiCriterioVO = new TipoSubservicioCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoSubservicioVO entiVO = tpssDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new Error("Tipo de servicio no encontrado: " + id);
            }

            final EntidadBO entiBO = new EntidadBO();

            entiBO.fillDependencies(session, entiVO, idioma);

            return entiVO;
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
    public final void insert(final TipoSubservicioVO tpssVO, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpssVO);
        Preconditions.checkNotNull(tpssVO.getTpsrId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final Long id = entiDAO.nextSequence();

            tpssVO.setId(id);
            tpssVO.setTipo(TipoEntidad.P);

            if (entiDAO.exists(tpssVO)) {
                throw new DuplicateInstanceException(TipoSubservicioVO.class.getName(), tpssVO);
            }

            entiDAO.insert(tpssVO);
            tpssDAO.insert(tpssVO);

            I18nBO.insertMap(session, I18nPrefix.enti, tpssVO.getId(), i18nMap);

            session.commit();
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
    public final void update(final TipoSubservicioVO tpssVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpssVO);
        Preconditions.checkNotNull(tpssVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final int updated = tpssDAO.update(tpssVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoSubservicioVO.class.getName(), tpssVO);
            }

            entiDAO.update(tpssVO);

            I18nBO.updateMap(session, I18nPrefix.enti, tpssVO.getId(), i18nMap);

            session.commit();
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            I18nBO.deleteMap(session, I18nPrefix.enti, tpssId);

            final int updated = tpssDAO.delete(tpssId);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoSubservicioVO.class.getName(), tpssId);
            }

            entiDAO.delete(tpssId);

            session.commit();
        }
    }
}
