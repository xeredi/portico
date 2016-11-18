package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoParametroDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

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
        final List<LabelValueVO> list = new ArrayList<>();

        for (final TipoParametroVO tppr : selectList(new TipoParametroCriterioVO())) {
            list.add(new LabelValueVO(tppr.getNombre(), tppr.getId()));
        }

        return list;
    }

    /**
     * Select list.
     *
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @return the list
     */
    public List<TipoParametroVO> selectList(@NonNull final TipoParametroCriterioVO tpprCriterioVO) {
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
    public PaginatedList<TipoParametroVO> selectList(@NonNull final TipoParametroCriterioVO tpprCriterioVO,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);
            final int count = tpprDAO.count(tpprCriterioVO);

            return new PaginatedList<>(count > offset ? tpprDAO.selectList(tpprCriterioVO, new RowBounds(offset, limit))
                    : new ArrayList<>(), offset, limit, count);
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
    public TipoParametroVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);
            final TipoParametroCriterioVO entiCriterio = new TipoParametroCriterioVO();

            entiCriterio.setId(id);
            entiCriterio.setIdioma(idioma);

            final TipoParametroVO enti = tpprDAO.selectObject(entiCriterio);

            if (enti == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tppr, id);
            }

            return enti;
        }
    }

    /**
     * Insert.
     *
     * @param tppr
     *            the tppr
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(@NonNull final TipoParametroVO tppr, @NonNull final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (entiDAO.exists(tppr)) {
                throw new DuplicateInstanceException(MessageI18nKey.tppr, tppr);
            }

            IgUtilBO.assignNextVal(tppr);
            tppr.setTipo(TipoEntidad.P);

            entiDAO.insert(tppr);
            tpprDAO.insert(tppr);

            I18nUtilBO.insertMap(session, tppr, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tppr
     *            the tppr
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(@NonNull final TipoParametroVO tppr, @NonNull final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tppr.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpprDAO.update(tppr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tppr, tppr);
            }

            entiDAO.update(tppr);
            I18nUtilBO.updateMap(session, tppr, i18nMap);

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
    public void delete(@NonNull final TipoParametroVO tppr) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tppr.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpprDAO.delete(tppr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tppr, tppr);
            }

            I18nUtilBO.deleteMap(session, tppr);
            entiDAO.delete(tppr);

            session.commit();
        }
    }
}
