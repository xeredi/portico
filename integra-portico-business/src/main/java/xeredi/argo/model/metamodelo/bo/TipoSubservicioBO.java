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
import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoSubservicioDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioAdminBO.
 */
public final class TipoSubservicioBO {

    /**
     * Select label values.
     *
     * @param tpssCriterio
     *            the tpss criterio
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues(final @NonNull TipoSubservicioCriterioVO tpssCriterio) {
        final List<LabelValueVO> list = new ArrayList<>();

        for (final TipoSubservicioVO tpss : selectList(tpssCriterio)) {
            list.add(new LabelValueVO(tpss.getNombre(), tpss.getId()));
        }

        return list;
    }

    /**
     * Select list.
     *
     * @param tpssCriterio
     *            the tpss criterio
     * @return the list
     */
    public List<TipoSubservicioVO> selectList(final @NonNull TipoSubservicioCriterioVO tpssCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);

            return tpssDAO.selectList(tpssCriterio);
        }
    }

    /**
     * Select list.
     *
     * @param tpssCriterio
     *            the tpss criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<TipoSubservicioVO> selectList(final @NonNull TipoSubservicioCriterioVO tpssCriterio,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            final int count = tpssDAO.count(tpssCriterio);
            final List<TipoSubservicioVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpssDAO.selectList(tpssCriterio, new RowBounds(offset, limit)));
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
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TipoSubservicioVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            final TipoSubservicioCriterioVO entiCriterio = new TipoSubservicioCriterioVO();

            entiCriterio.setId(id);
            entiCriterio.setIdioma(idioma);

            final TipoSubservicioVO enti = tpssDAO.selectObject(entiCriterio);

            if (enti == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tpss, id);
            }

            return enti;
        }
    }

    /**
     * Insert.
     *
     * @param tpss
     *            the tpss
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull TipoSubservicioVO tpss, final @NonNull Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpss.getTpsrId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
            final IgBO igBO = new IgBO();

            if (entiDAO.exists(tpss)) {
                throw new DuplicateInstanceException(MessageI18nKey.tpss, tpss);
            }

            igBO.assignNextVal(tpss);
            tpss.setTipo(TipoEntidad.S);

            entiDAO.insert(tpss);
            tpssDAO.insert(tpss);
            I18nUtilBO.insertMap(session, tpss, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpss
     *            the tpss
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull TipoSubservicioVO tpss, final @NonNull Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpss.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpssDAO.update(tpss) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpss, tpss);
            }

            entiDAO.update(tpss);
            I18nUtilBO.updateMap(session, tpss, i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param tpss
     *            the tpss
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull TipoSubservicioVO tpss) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpss.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpssDAO.delete(tpss) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpss, tpss);
            }

            entiDAO.delete(tpss);
            I18nUtilBO.deleteMap(session, tpss);

            session.commit();
        }
    }
}
