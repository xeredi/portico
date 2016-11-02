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
import xeredi.argo.model.metamodelo.dao.TipoServicioDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioAdminBO.
 */
public final class TipoServicioBO {
    /**
     * Select label values.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues(final @NonNull TipoServicioCriterioVO criterioVO) {
        final List<LabelValueVO> list = new ArrayList<>();

        for (final TipoServicioVO tpsr : selectList(criterioVO)) {
            list.add(new LabelValueVO(tpsr.getNombre(), tpsr.getId()));
        }

        return list;
    }

    /**
     * Select list.
     *
     * @param tpsrCriterio
     *            the tpsr criterio
     * @return the list
     */
    public List<TipoServicioVO> selectList(final @NonNull TipoServicioCriterioVO tpsrCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);

            return tpsrDAO.selectList(tpsrCriterio);
        }
    }

    /**
     * Select list.
     *
     * @param tpsrCriterio
     *            the tpsr criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<TipoServicioVO> selectList(final @NonNull TipoServicioCriterioVO tpsrCriterio,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);
            final int count = tpsrDAO.count(tpsrCriterio);
            final List<TipoServicioVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpsrDAO.selectList(tpsrCriterio, new RowBounds(offset, limit)));
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
     * @return the tipo servicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TipoServicioVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);
            final TipoServicioCriterioVO entiCriterio = new TipoServicioCriterioVO();

            entiCriterio.setId(id);
            entiCriterio.setIdioma(idioma);

            final TipoServicioVO enti = tpsrDAO.selectObject(entiCriterio);

            if (enti == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsr, id);
            }

            return enti;
        }
    }

    /**
     * Insert.
     *
     * @param tpsr
     *            the tpsr
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull TipoServicioVO tpsr, final @NonNull Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
            final IgBO igBO = new IgBO();

            if (entiDAO.exists(tpsr)) {
                throw new DuplicateInstanceException(MessageI18nKey.tpsr, tpsr);
            }

            igBO.assignNextVal(tpsr);
            tpsr.setTipo(TipoEntidad.T);

            entiDAO.insert(tpsr);
            tpsrDAO.insert(tpsr);
            I18nUtilBO.insertMap(session, tpsr, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpsr
     *            the tpsr
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull TipoServicioVO tpsr, final @NonNull Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpsr.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpsrDAO.update(tpsr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsr, tpsr);
            }

            entiDAO.update(tpsr);
            I18nUtilBO.updateMap(session, tpsr, i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param tpsr
     *            the tpsr
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull TipoServicioVO tpsr) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpsr.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpsrDAO.delete(tpsr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsr, tpsr);
            }

            I18nUtilBO.deleteMap(session, tpsr);
            entiDAO.delete(tpsr);

            session.commit();
        }
    }
}
