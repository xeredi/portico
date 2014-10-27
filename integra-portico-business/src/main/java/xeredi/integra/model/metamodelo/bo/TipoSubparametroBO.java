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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpspDAO = session.getMapper(TipoSubparametroDAO.class);

            final List<LabelValueVO> list = new ArrayList<>();

            for (final TipoSubparametroVO tpsp : tpspDAO.selectList(new TipoSubparametroCriterioVO())) {
                list.add(new LabelValueVO(tpsp.getNombre(), tpsp.getId()));
            }

            return list;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpspDAO = session.getMapper(TipoSubparametroDAO.class);

            return tpspDAO.selectList(tpspCriterioVO);
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpspDAO = session.getMapper(TipoSubparametroDAO.class);

            final int count = tpspDAO.count(tpspCriterioVO);
            final List<TipoSubparametroVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpspDAO.selectList(tpspCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<>(list, offset, limit, count);
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo subparametro vo
     */
    public final TipoSubparametroVO select(final Long id, final String idioma) {
        Preconditions.checkNotNull(id);
        Preconditions.checkNotNull(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            tpspDAO = session.getMapper(TipoSubparametroDAO.class);

            final TipoSubparametroCriterioVO entiCriterioVO = new TipoSubparametroCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoSubparametroVO entiVO = tpspDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new Error("Tipo de subparametro no encontrado: " + id);
            }

            final EntidadBO entiBO = new EntidadBO();

            entiBO.fillDependencies(session, entiVO, idioma);

            return entiVO;
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
    public final void insert(final TipoSubparametroVO tpspVO, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpspVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final Long id = entiDAO.nextSequence();

            tpspVO.setId(id);
            tpspVO.setTipo(TipoEntidad.B);

            if (entiDAO.exists(tpspVO)) {
                throw new DuplicateInstanceException(TipoSubparametroVO.class.getName(), tpspVO);
            }

            entiDAO.insert(tpspVO);
            tpspDAO.insert(tpspVO);

            I18nBO.insertMap(session, I18nPrefix.enti, tpspVO.getId(), i18nMap);

            session.commit();
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
    public final void update(final TipoSubparametroVO tpspVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpspVO);
        Preconditions.checkNotNull(tpspVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            final int updated = tpspDAO.update(tpspVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoSubparametroVO.class.getName(), tpspVO);
            }

            entiDAO.update(tpspVO);

            I18nBO.updateMap(session, I18nPrefix.enti, tpspVO.getId(), i18nMap);

            session.commit();
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            entiDAO = session.getMapper(EntidadDAO.class);

            I18nBO.deleteMap(session, I18nPrefix.enti, tpspId);

            final int updated = tpspDAO.delete(tpspId);

            if (updated == 0) {
                throw new InstanceNotFoundException(TipoSubparametroVO.class.getName(), tpspId);
            }

            entiDAO.delete(tpspId);

            session.commit();
        }
    }
}
