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
import xeredi.argo.model.facturacion.dao.CargoDAO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.util.DateUtil;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoBO.
 */
public class CargoBO {

    /**
     * Select list.
     *
     * @param crgoCriterioVO
     *            the crgo criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<CargoVO> selectList(final @NonNull CargoCriterioVO crgoCriterioVO, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);
            final int count = crgoDAO.count(crgoCriterioVO);

            return new PaginatedList<CargoVO>(count > offset
                    ? crgoDAO.selectList(crgoCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(), offset,
                    limit, count);
        }
    }

    /**
     * Select label value list.
     *
     * @param crgoCriterio
     *            the crgo criterio
     * @param limit
     *            the limit
     * @return the list
     */
    public List<CargoVO> selectTypeaheadList(final @NonNull CargoCriterioVO crgoCriterio, final int limit) {
        crgoCriterio.setTextoBusqueda("%" + crgoCriterio.getTextoBusqueda() + "%");

        if (crgoCriterio.getFechaVigencia() == null) {
            crgoCriterio.setFechaVigencia(Calendar.getInstance().getTime());
        }

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);

            return crgoDAO.selectList(crgoCriterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
        }
    }

    /**
     * Select label value list.
     *
     * @param crgoCriterioVO
     *            the crgo criterio vo
     * @return the list
     */
    public List<CargoVO> selectList(final @NonNull CargoCriterioVO crgoCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);

            return crgoDAO.selectList(crgoCriterioVO);
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
     * @return the cargo VO
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public CargoVO select(final @NonNull Long id, final @NonNull Date fref, final String idioma)
            throws InstanceNotFoundException {
        final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

        crgoCriterio.setId(id);
        crgoCriterio.setFechaVigencia(fref);
        crgoCriterio.setIdioma(idioma);

        return selectObject(crgoCriterio);
    }

    /**
     * Select.
     *
     * @param crgoCriterio
     *            the crgo criterio
     * @return the cargo vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public CargoVO selectObject(final @NonNull CargoCriterioVO crgoCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);
            final CargoVO crgo = crgoDAO.selectObject(crgoCriterio);

            if (crgo == null) {
                throw new InstanceNotFoundException(MessageI18nKey.crgo, crgoCriterio);
            }

            return crgo;
        }
    }

    /**
     * Insert.
     *
     * @param crgo
     *            the crgo
     * @param i18nMap
     *            the i18n map
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(final @NonNull CargoVO crgo, final Map<String, I18nVO> i18nMap) throws OverlapException {
        Preconditions.checkNotNull(crgo.getVersion());
        Preconditions.checkNotNull(crgo.getVersion().getFini());
        Preconditions.checkNotNull(crgo.getTpsr());
        Preconditions.checkNotNull(crgo.getTpsr().getId());

        DateUtil.truncTime(crgo.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(crgo.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);

            if (crgoDAO.exists(crgo)) {
                crgo.setId(crgoDAO.selectId(crgo));

                if (crgoDAO.existsOverlap(crgo)) {
                    throw new OverlapException(MessageI18nKey.crgo, crgo);
                }
            } else {
                IgUtilBO.assignNextVal(crgo);

                crgoDAO.insert(crgo);
            }

            IgUtilBO.assignNextVal(crgo.getVersion());

            crgoDAO.insertVersion(crgo);

            I18nUtilBO.insertMap(session, crgo, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param crgo
     *            the crgo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public void update(final @NonNull CargoVO crgo, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(crgo.getVersion());
        Preconditions.checkNotNull(crgo.getVersion().getId());

        DateUtil.truncTime(crgo.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(crgo.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);

            if (crgoDAO.existsOverlap(crgo)) {
                throw new OverlapException(MessageI18nKey.crgo, crgo);
            }

            final int updated = crgoDAO.updateVersion(crgo);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.crgo, crgo);
            }

            I18nUtilBO.updateMap(session, crgo, i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param crgo
     *            the crgo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull CargoVO crgo) throws InstanceNotFoundException {
        Preconditions.checkNotNull(crgo.getVersion());
        Preconditions.checkNotNull(crgo.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);

            if (crgoDAO.deleteVersion(crgo) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.crgo, crgo);
            }

            I18nUtilBO.deleteMap(session, crgo);

            session.commit();
        }
    }

}
