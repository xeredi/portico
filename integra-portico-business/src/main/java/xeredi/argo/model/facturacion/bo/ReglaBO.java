package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.ReglaDAO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.util.DateUtil;
import xeredi.argo.model.util.PaginatedList;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaBO.
 */
public final class ReglaBO {
    /**
     * Select list.
     *
     * @param rglaCriterioVO
     *            the rgla criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ReglaVO> selectList(@NonNull final ReglaCriterioVO rglaCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);
            final int count = rglaDAO.count(rglaCriterioVO);

            return new PaginatedList<ReglaVO>(count > offset
                    ? rglaDAO.selectList(rglaCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(), offset,
                    limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param rglaCriterioVO
     *            the rgla criterio vo
     * @return the list
     */
    public List<ReglaVO> selectList(@NonNull final ReglaCriterioVO rglaCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);

            return rglaDAO.selectList(rglaCriterioVO);
        }
    }

    /**
     * Select lupa list.
     *
     * @param rglaCriterio
     *            the rgla criterio
     * @param limit
     *            the limit
     * @return the list
     */
    public List<ReglaVO> selectTypeaheadList(@NonNull final ReglaCriterioVO rglaCriterio, final int limit) {
        rglaCriterio.setTextoBusqueda("%" + rglaCriterio.getTextoBusqueda() + "%");

        if (rglaCriterio.getFechaVigencia() == null) {
            rglaCriterio.setFechaVigencia(Calendar.getInstance().getTime());
        }

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);

            return rglaDAO.selectList(rglaCriterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
        }
    }

    /**
     * Insert.
     *
     * @param rgla
     *            the rgla
     * @param i18nMap
     *            the i18n map
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(@NonNull final ReglaVO rgla, final Map<String, I18nVO> i18nMap) throws OverlapException {
        Preconditions.checkNotNull(rgla.getVersion());
        Preconditions.checkNotNull(rgla.getVersion().getFini());
        Preconditions.checkNotNull(rgla.getCrgo());
        Preconditions.checkNotNull(rgla.getCrgo().getId());
        Preconditions.checkNotNull(rgla.getEnti());
        Preconditions.checkNotNull(rgla.getEnti().getId());
        Preconditions.checkNotNull(rgla.getTipo());

        DateUtil.truncTime(rgla.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(rgla.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);

            if (rglaDAO.exists(rgla)) {
                rgla.setId(rglaDAO.selectId(rgla));

                if (rglaDAO.existsOverlap(rgla)) {
                    throw new OverlapException(MessageI18nKey.rgla, rgla);
                }
            } else {
                IgUtilBO.assignNextVal(rgla);
                rglaDAO.insert(rgla);
            }

            IgUtilBO.assignNextVal(rgla.getVersion());

            rglaDAO.insertVersion(rgla);

            I18nUtilBO.insertMap(session, rgla, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param rgla
     *            the rgla
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public void update(@NonNull final ReglaVO rgla, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(rgla.getVersion());
        Preconditions.checkNotNull(rgla.getVersion().getId());

        DateUtil.truncTime(rgla.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(rgla.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);

            if (rglaDAO.existsOverlap(rgla)) {
                throw new OverlapException(MessageI18nKey.rgla, rgla);
            }

            final int updated = rglaDAO.updateVersion(rgla);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.rgla, rgla);
            }

            I18nUtilBO.updateMap(session, rgla, i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param rgla
     *            the rgla
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(@NonNull final ReglaVO rgla) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rgla.getVersion());
        Preconditions.checkNotNull(rgla.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);
            final int updated = rglaDAO.deleteVersion(rgla);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.rgla, rgla);
            }

            I18nUtilBO.deleteMap(session, rgla);

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param fref
     *            the fref
     * @param idioma
     *            the idioma
     * @return the regla VO
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ReglaVO select(@NonNull final Long id, @NonNull final Date fref, final String idioma)
            throws InstanceNotFoundException {
        final ReglaCriterioVO rglaCriterio = new ReglaCriterioVO();

        rglaCriterio.setId(id);
        rglaCriterio.setFechaVigencia(fref);
        rglaCriterio.setIdioma(idioma);

        return selectObject(rglaCriterio);
    }

    /**
     * Select.
     *
     * @param rglaCriterio
     *            the rgla criterio
     * @return the regla vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ReglaVO selectObject(@NonNull final ReglaCriterioVO rglaCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);
            final ReglaVO rgla = rglaDAO.selectObject(rglaCriterio);

            if (rgla == null) {
                throw new InstanceNotFoundException(MessageI18nKey.rgla, rglaCriterio);
            }

            return rgla;
        }
    }
}
