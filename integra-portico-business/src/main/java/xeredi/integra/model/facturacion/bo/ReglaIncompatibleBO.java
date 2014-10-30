package xeredi.integra.model.facturacion.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.dao.ReglaIncompatibleDAO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleBO.
 */
public class ReglaIncompatibleBO {

    /** The rgin dao. */
    ReglaIncompatibleDAO rginDAO;

    /**
     * {@inheritDoc}
     */
    public void insert(final ReglaIncompatibleVO rgin) throws OverlapException {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgla1Id());
        Preconditions.checkNotNull(rgin.getRgla2());
        Preconditions.checkNotNull(rgin.getRgla2().getId());
        Preconditions.checkNotNull(rgin.getRgiv());
        Preconditions.checkNotNull(rgin.getRgiv().getFini());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            rginDAO = session.getMapper(ReglaIncompatibleDAO.class);

            final IgBO igBO = new IgBO();

            if (rginDAO.exists(rgin)) {
                rgin.setId(rginDAO.selectId(rgin));

                if (rginDAO.existsOverlap(rgin)) {
                    throw new OverlapException(MessageI18nKey.rgin, rgin);
                }
            } else {
                rgin.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                rginDAO.insert(rgin);
            }

            rgin.getRgiv().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

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
    public void update(final ReglaIncompatibleVO rgin) throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgiv());
        Preconditions.checkNotNull(rgin.getRgiv().getId());
        Preconditions.checkNotNull(rgin.getRgiv().getFini());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            rginDAO = session.getMapper(ReglaIncompatibleDAO.class);

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
    public void delete(final ReglaIncompatibleVO rgin) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgiv());
        Preconditions.checkNotNull(rgin.getRgiv().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            rginDAO = session.getMapper(ReglaIncompatibleDAO.class);

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
     * @param rginCriterio
     *            the rgin criterio
     * @return the regla incompatible vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ReglaIncompatibleVO select(final ReglaIncompatibleCriterioVO rginCriterio) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rginCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            rginDAO = session.getMapper(ReglaIncompatibleDAO.class);

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
    public List<ReglaIncompatibleVO> selectList(final ReglaIncompatibleCriterioVO rginCriterio) {
        Preconditions.checkNotNull(rginCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            rginDAO = session.getMapper(ReglaIncompatibleDAO.class);

            return rginDAO.selectList(rginCriterio);
        }
    }

}
