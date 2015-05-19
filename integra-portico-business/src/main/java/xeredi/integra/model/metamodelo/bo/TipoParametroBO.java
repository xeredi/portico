package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.NonNull;

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
import xeredi.integra.model.metamodelo.dao.TipoParametroDAO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroAdminBO.
 */
public final class TipoParametroBO {
    /**
     * Select label values.
     *
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues() {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);
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
    public List<TipoParametroVO> selectList(final TipoParametroCriterioVO tpprCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);

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
    public PaginatedList<TipoParametroVO> selectList(final TipoParametroCriterioVO tpprCriterioVO, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);
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
     * @param idioma
     *            the idioma
     * @return the tipo parametro vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TipoParametroVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);
            final TipoParametroCriterioVO entiCriterioVO = new TipoParametroCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoParametroVO entiVO = tpprDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tppr, id);
            }

            return entiVO;
        }
    }

    /**
     * Insert.
     *
     * @param tpprVO
     *            the tppr vo
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (entiDAO.exists(tpprVO)) {
                throw new DuplicateInstanceException(MessageI18nKey.tppr, tpprVO);
            }

            final Long id = entiDAO.nextSequence();

            tpprVO.setId(id);
            tpprVO.setTipo(TipoEntidad.P);

            entiDAO.insert(tpprVO);
            tpprDAO.insert(tpprVO);

            I18nBO.insertMap(session, I18nPrefix.enti, tpprVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpprVO
     *            the tppr vo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpprVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpprDAO.update(tpprVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tppr, tpprVO);
            }

            entiDAO.update(tpprVO);
            I18nBO.updateMap(session, I18nPrefix.enti, tpprVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param tppr
     *            the tppr
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull TipoParametroVO tppr) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tppr.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpprDAO.delete(tppr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tppr, tppr);
            }

            I18nBO.deleteMap(session, I18nPrefix.enti, tppr.getId());
            entiDAO.delete(tppr);

            session.commit();
        }
    }
}
