package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.dao.FacturaSerieDAO;
import xeredi.integra.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

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
            final IgBO igBO = new IgBO();

            if (fcsrDAO.exists(fcsr)) {
                throw new DuplicateInstanceException(MessageI18nKey.fcsr, fcsr);
            }

            fcsr.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
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
     * @param fcsrId
     *            the fcsr id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final Long fcsrId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(fcsrId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);

            if (fcsrDAO.delete(fcsrId) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.fcsr, fcsrId);
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
            final FacturaSerieVO fcsr = fcsrDAO.select(fcsrId);

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
            final List<FacturaSerieVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(fcsrDAO.selectList(fcsrCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<FacturaSerieVO>(list, offset, limit, count);
        }
    }

    /**
     * Select label value list.
     *
     * @param fcsrCriterio
     *            the fcsr criterio
     * @return the list
     */
    public List<LabelValueVO> selectLabelValueList(final FacturaSerieCriterioVO fcsrCriterio) {
        Preconditions.checkNotNull(fcsrCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);

            return fcsrDAO.selectLabelValueList(fcsrCriterio);
        }
    }
}
