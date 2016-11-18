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
import xeredi.argo.model.metamodelo.dao.TipoEstadisticaDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

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
        final List<LabelValueVO> list = new ArrayList<>();

        for (final TipoEstadisticaVO tpes : selectList(new TipoEstadisticaCriterioVO())) {
            list.add(new LabelValueVO(tpes.getNombre(), tpes.getId()));
        }

        return list;
    }

    /**
     * Select list.
     *
     * @param tpesCriterio
     *            the tpes criterio
     * @return the list
     */
    public List<TipoEstadisticaVO> selectList(@NonNull final TipoEstadisticaCriterioVO tpesCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);

            return tpesDAO.selectList(tpesCriterio);
        }
    }

    /**
     * Select list.
     *
     * @param tpesCriterio
     *            the tpes criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<TipoEstadisticaVO> selectList(@NonNull final TipoEstadisticaCriterioVO tpesCriterio,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
            final int count = tpesDAO.count(tpesCriterio);

            return new PaginatedList<>(
                    count > offset ? tpesDAO.selectList(tpesCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
                    offset, limit, count);
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
    public TipoEstadisticaVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
            final TipoEstadisticaCriterioVO entiCriterio = new TipoEstadisticaCriterioVO();

            entiCriterio.setId(id);
            entiCriterio.setIdioma(idioma);

            final TipoEstadisticaVO enti = tpesDAO.selectObject(entiCriterio);

            if (enti == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tpes, id);
            }

            return enti;
        }
    }

    /**
     * Insert.
     *
     * @param tpes
     *            the tpes
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(@NonNull final TipoEstadisticaVO tpes, @NonNull final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (entiDAO.exists(tpes)) {
                throw new DuplicateInstanceException(MessageI18nKey.tpes, tpes);
            }

            IgUtilBO.assignNextVal(tpes);
            tpes.setTipo(TipoEntidad.E);

            entiDAO.insert(tpes);
            tpesDAO.insert(tpes);

            I18nUtilBO.insertMap(session, tpes, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpes
     *            the tpes
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(@NonNull final TipoEstadisticaVO tpes, @NonNull final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpes.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (entiDAO.update(tpes) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpes, tpes);
            }

            I18nUtilBO.updateMap(session, tpes, i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param tpes
     *            the tpes
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(@NonNull final TipoEstadisticaVO tpes) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpes.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpesDAO.delete(tpes) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpes, tpes);
            }

            I18nUtilBO.deleteMap(session, tpes);

            entiDAO.delete(tpes);

            session.commit();
        }
    }
}
