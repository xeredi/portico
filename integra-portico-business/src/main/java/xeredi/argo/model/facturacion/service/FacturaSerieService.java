package xeredi.argo.model.facturacion.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaSerieService.
 */
public interface FacturaSerieService {

	/**
	 * Insert.
	 *
	 * @param fcsr
	 *            the fcsr
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	void insert(final FacturaSerieVO fcsr) throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param fcsr
	 *            the fcsr
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(final FacturaSerieVO fcsr) throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param fcsr
	 *            the fcsr
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final FacturaSerieVO fcsr) throws InstanceNotFoundException;

	/**
	 * Select.
	 *
	 * @param fcsrId
	 *            the fcsr id
	 * @return the factura serie VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	FacturaSerieVO select(final Long fcsrId) throws InstanceNotFoundException;

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
	PaginatedList<FacturaSerieVO> selectList(final FacturaSerieCriterioVO fcsrCriterio, final int offset,
			final int limit);

	/**
	 * Select list.
	 *
	 * @param fcsrCriterio
	 *            the fcsr criterio
	 * @return the list
	 */
	List<FacturaSerieVO> selectList(final FacturaSerieCriterioVO fcsrCriterio);
}
