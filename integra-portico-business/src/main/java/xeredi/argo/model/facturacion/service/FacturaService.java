package xeredi.argo.model.facturacion.service;

import java.util.List;
import java.util.Set;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaImpresionVO;
import xeredi.argo.model.facturacion.vo.FacturaTypeaheadCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaService.
 */
public interface FacturaService {

	/**
	 * Select imprimir.
	 *
	 * @param fctrIds
	 *            the fctr ids
	 * @param idioma
	 *            the idioma
	 * @return the list
	 */
	List<FacturaImpresionVO> selectImprimir(@NonNull final Set<Long> fctrIds, final String idioma);

	/**
	 * Select.
	 *
	 * @param fctrId
	 *            the fctr id
	 * @param idioma
	 *            the idioma
	 * @return the factura VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	FacturaVO select(@NonNull final Long fctrId, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param fctrCriterio
	 *            the fctr criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<FacturaVO> selectList(@NonNull final FacturaCriterioVO fctrCriterio, final int offset,
			final int limit);

	/**
	 * Select typeahead list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param limit
	 *            the limit
	 * @return the list
	 */
	List<FacturaVO> selectTypeaheadList(@NonNull final FacturaTypeaheadCriterioVO criterio, final int limit);

}
