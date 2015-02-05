package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.dao.CampoAgregacionDAO;
import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.TipoEstadisticaDAO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaBO.
 */
public final class TipoEstadisticaBO {
    /**
     * Select label values.
     *
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues() {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
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
    public List<TipoEstadisticaVO> selectList(final @Nonnull TipoEstadisticaCriterioVO tpesCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);

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
    public PaginatedList<TipoEstadisticaVO> selectList(final @Nonnull TipoEstadisticaCriterioVO tpesCriterioVO,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
            final int count = tpesDAO.count(tpesCriterioVO);
            final List<TipoEstadisticaVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpesDAO.selectPaginatedList(tpesCriterioVO, new RowBounds(offset, limit)));
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
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TipoEstadisticaVO select(final @Nonnull Long id, final @Nonnull String idioma)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
            final TipoEstadisticaCriterioVO entiCriterioVO = new TipoEstadisticaCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoEstadisticaVO entiVO = tpesDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tpes, id);
            }

            final CampoAgregacionDAO cmagDAO = session.getMapper(CampoAgregacionDAO.class);
            final CampoAgregacionCriterioVO cmagCriterioVO = new CampoAgregacionCriterioVO();

            cmagCriterioVO.setTpesId(entiVO.getId());

            entiVO.setCmagList(cmagDAO.selectList(cmagCriterioVO));

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
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @Nonnull TipoEstadisticaVO tpesVO, final @Nonnull Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
            final Long id = entiDAO.nextSequence();

            tpesVO.setId(id);
            tpesVO.setTipo(TipoEntidad.E);

            if (entiDAO.exists(tpesVO)) {
                throw new DuplicateInstanceException(MessageI18nKey.tpes, tpesVO);
            }

            entiDAO.insert(tpesVO);
            tpesDAO.insert(tpesVO);

            I18nBO.insertMap(session, I18nPrefix.enti, tpesVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpesVO
     *            the tpes vo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @Nonnull TipoEstadisticaVO tpesVO, final @Nonnull Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpesVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (entiDAO.update(tpesVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpes, tpesVO);
            }

            I18nBO.updateMap(session, I18nPrefix.enti, tpesVO.getId(), i18nMap);

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
    public void delete(final @Nonnull Long tpesId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpesDAO.delete(tpesId) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpes, tpesId);
            }

            I18nBO.deleteMap(session, I18nPrefix.enti, tpesId);

            entiDAO.delete(tpesId);

            session.commit();
        }
    }
}
