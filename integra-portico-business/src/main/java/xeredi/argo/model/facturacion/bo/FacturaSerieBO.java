package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.FacturaSerieDAO;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.util.PaginatedList;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieBO.
 */
public final class FacturaSerieBO {

    /**
     * Insert.
     *
     * @param fcsr
     *            the fcsr
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final FacturaSerieVO fcsr) throws DuplicateInstanceException {
        Preconditions.checkNotNull(fcsr);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);

            if (fcsrDAO.exists(fcsr)) {
                throw new DuplicateInstanceException(MessageI18nKey.fcsr, fcsr);
            }

            IgUtilBO.assignNextVal(fcsr);
            fcsrDAO.insert(fcsr);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param fcsr
     *            the fcsr
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final FacturaSerieVO fcsr) throws InstanceNotFoundException {
        Preconditions.checkNotNull(fcsr);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);

            if (fcsrDAO.update(fcsr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.fcsr, fcsr);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param fcsr
     *            the fcsr
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(@NonNull final FacturaSerieVO fcsr) throws InstanceNotFoundException {
        Preconditions.checkNotNull(fcsr.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);

            if (fcsrDAO.delete(fcsr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.fcsr, fcsr);
            }

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param fcsrId
     *            the fcsr id
     * @return the factura serie vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public FacturaSerieVO select(final Long fcsrId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(fcsrId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);
            final FacturaSerieCriterioVO fcsrCriterio = new FacturaSerieCriterioVO();

            fcsrCriterio.setId(fcsrId);

            final FacturaSerieVO fcsr = fcsrDAO.selectObject(fcsrCriterio);

            if (fcsr == null) {
                throw new InstanceNotFoundException(MessageI18nKey.fcsr, fcsrId);
            }

            return fcsr;
        }
    }

    /**
     * Select list.
     *
     * @param fcsrCriterio
     *            the fcsr criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<FacturaSerieVO> selectList(final FacturaSerieCriterioVO fcsrCriterio, final int offset,
            final int limit) {
        Preconditions.checkNotNull(fcsrCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);
            final int count = fcsrDAO.count(fcsrCriterio);

            return new PaginatedList<FacturaSerieVO>(
                    count > offset ? fcsrDAO.selectList(fcsrCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
                    offset, limit, count);
        }
    }

    /**
     * Select label value list.
     *
     * @param fcsrCriterio
     *            the fcsr criterio
     * @return the list
     */
    public List<FacturaSerieVO> selectList(final FacturaSerieCriterioVO fcsrCriterio) {
        Preconditions.checkNotNull(fcsrCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);

            return fcsrDAO.selectList(fcsrCriterio);
        }
    }
}
