package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.TipoSubparametroDAO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroBO.
 */
public final class TipoSubparametroBO {
    /**
     * Select label values.
     *
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues() {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
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
    public List<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);

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
    public PaginatedList<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final int count = tpspDAO.count(tpspCriterioVO);
            final List<TipoSubparametroVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpspDAO.selectPaginatedList(tpspCriterioVO, new RowBounds(offset, limit)));
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
     * @return the tipo subparametro vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TipoSubparametroVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final TipoSubparametroCriterioVO entiCriterioVO = new TipoSubparametroCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoSubparametroVO entiVO = tpspDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsp, id);
            }

            return entiVO;
        }
    }

    /**
     * Insert.
     *
     * @param tpspVO
     *            the tpsp vo
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final TipoSubparametroVO tpspVO, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (entiDAO.exists(tpspVO)) {
                throw new DuplicateInstanceException(MessageI18nKey.tpsp, tpspVO);
            }

            tpspVO.setId(entiDAO.nextSequence());
            tpspVO.setTipo(TipoEntidad.B);

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
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final TipoSubparametroVO tpspVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpspVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpspDAO.update(tpspVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsp, tpspVO);
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
    public void delete(final Long tpspId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpspDAO.delete(tpspId) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsp, tpspId);
            }

            entiDAO.delete(tpspId);
            I18nBO.deleteMap(session, I18nPrefix.enti, tpspId);

            session.commit();
        }
    }
}
