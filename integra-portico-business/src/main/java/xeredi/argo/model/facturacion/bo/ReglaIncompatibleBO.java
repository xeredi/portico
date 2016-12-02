package xeredi.argo.model.facturacion.bo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.ReglaIncompatibleDAO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.argo.model.util.DateUtil;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleBO.
 */
public final class ReglaIncompatibleBO {

    /**
     * Insert.
     *
     * @param rgin
     *            the rgin
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(@NonNull final ReglaIncompatibleVO rgin) throws OverlapException {
        Preconditions.checkNotNull(rgin.getRgla1Id());
        Preconditions.checkNotNull(rgin.getRgla2());
        Preconditions.checkNotNull(rgin.getRgla2().getId());
        Preconditions.checkNotNull(rgin.getVersion());
        Preconditions.checkNotNull(rgin.getVersion().getFini());

        DateUtil.truncTime(rgin.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(rgin.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaIncompatibleDAO rginDAO = session.getMapper(ReglaIncompatibleDAO.class);

            if (rginDAO.exists(rgin)) {
                rgin.setId(rginDAO.selectId(rgin));

                if (rginDAO.existsOverlap(rgin)) {
                    throw new OverlapException(MessageI18nKey.rgin, rgin);
                }
            } else {
                IgUtilBO.assignNextVal(rgin);
                rginDAO.insert(rgin);
            }

            IgUtilBO.assignNextVal(rgin.getVersion());
            rginDAO.insertVersion(rgin);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param rgin
     *            the rgin
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public void update(@NonNull final ReglaIncompatibleVO rgin) throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(rgin.getVersion());
        Preconditions.checkNotNull(rgin.getVersion().getId());
        Preconditions.checkNotNull(rgin.getVersion().getFini());

        DateUtil.truncTime(rgin.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(rgin.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaIncompatibleDAO rginDAO = session.getMapper(ReglaIncompatibleDAO.class);

            if (rginDAO.existsOverlap(rgin)) {
                throw new OverlapException(MessageI18nKey.rgin, rgin);
            }

            final int updated = rginDAO.updateVersion(rgin);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.rgin, rgin);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param rgin
     *            the rgin
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(@NonNull final ReglaIncompatibleVO rgin) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rgin.getVersion());
        Preconditions.checkNotNull(rgin.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaIncompatibleDAO rginDAO = session.getMapper(ReglaIncompatibleDAO.class);
            final int updated = rginDAO.deleteVersion(rgin);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.rgin, rgin);
            }

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
     * @return the regla incompatible VO
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ReglaIncompatibleVO select(@NonNull final Long id, @NonNull final Date fref)
            throws InstanceNotFoundException {
        final ReglaIncompatibleCriterioVO rginCriterio = new ReglaIncompatibleCriterioVO();

        rginCriterio.setId(id);
        rginCriterio.setFechaVigencia(fref);

        return selectObject(rginCriterio);
    }

    /**
     * Select.
     *
     * @param rginCriterio
     *            the rgin criterio
     * @return the regla incompatible vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ReglaIncompatibleVO selectObject(@NonNull final ReglaIncompatibleCriterioVO rginCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaIncompatibleDAO rginDAO = session.getMapper(ReglaIncompatibleDAO.class);
            final ReglaIncompatibleVO rgin = rginDAO.selectObject(rginCriterio);

            if (rgin == null) {
                throw new InstanceNotFoundException(MessageI18nKey.rgin, rginCriterio);
            }

            return rgin;
        }
    }

    /**
     * Select list.
     *
     * @param rginCriterio
     *            the rgin criterio
     * @return the list
     */
    public List<ReglaIncompatibleVO> selectList(@NonNull final ReglaIncompatibleCriterioVO rginCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaIncompatibleDAO rginDAO = session.getMapper(ReglaIncompatibleDAO.class);

            return rginDAO.selectList(rginCriterio);
        }
    }

}
