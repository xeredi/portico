package xeredi.argo.model.facturacion.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

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

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class FacturaSerieService {

	/** The fcsr DAO. */
	@Inject
	private FacturaSerieDAO fcsrDAO;

	/**
	 * Insert.
	 *
	 * @param fcsr
	 *            the fcsr
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(FacturaSerieVO fcsr) throws DuplicateInstanceException {
		Preconditions.checkNotNull(fcsr);

		if (fcsrDAO.exists(fcsr)) {
			throw new DuplicateInstanceException(MessageI18nKey.fcsr, fcsr);
		}

		IgUtilBO.assignNextVal(fcsr);
		fcsrDAO.insert(fcsr);
	}

	/**
	 * Update.
	 *
	 * @param fcsr
	 *            the fcsr
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final FacturaSerieVO fcsr) throws InstanceNotFoundException {
		Preconditions.checkNotNull(fcsr.getId());

		if (fcsrDAO.update(fcsr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.fcsr, fcsr);
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

		if (fcsrDAO.delete(fcsr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.fcsr, fcsr);
		}
	}

	/**
	 * Select.
	 *
	 * @param fcsrId
	 *            the fcsr id
	 * @return the factura serie VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public FacturaSerieVO select(@NonNull final Long fcsrId) throws InstanceNotFoundException {
		final FacturaSerieCriterioVO fcsrCriterio = new FacturaSerieCriterioVO();

		fcsrCriterio.setId(fcsrId);

		final FacturaSerieVO fcsr = fcsrDAO.selectObject(fcsrCriterio);

		if (fcsr == null) {
			throw new InstanceNotFoundException(MessageI18nKey.fcsr, fcsrId);
		}

		return fcsr;
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
	public PaginatedList<FacturaSerieVO> selectList(@NonNull final FacturaSerieCriterioVO fcsrCriterio, int offset,
			int limit) {
		final int count = fcsrDAO.count(fcsrCriterio);

		return new PaginatedList<FacturaSerieVO>(
				count > offset ? fcsrDAO.selectList(fcsrCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param fcsrCriterio
	 *            the fcsr criterio
	 * @return the list
	 */
	public List<FacturaSerieVO> selectList(@NonNull final FacturaSerieCriterioVO fcsrCriterio) {
		return fcsrDAO.selectList(fcsrCriterio);
	}
}
