package xeredi.argo.model.facturacion.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionDetalleService.
 */
public interface ValoracionDetalleService {

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the valoracion detalle VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	ValoracionDetalleVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param vlrdCriterio
	 *            the vlrd criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<ValoracionDetalleVO> selectList(@NonNull final ValoracionDetalleCriterioVO vlrdCriterio,
			final int offset, final int limit);

	/**
	 * Select list.
	 *
	 * @param vlrdCriterio
	 *            the vlrd criterio
	 * @return the list
	 */
	List<ValoracionDetalleVO> selectList(@NonNull final ValoracionDetalleCriterioVO vlrdCriterio);

	/**
	 * Insert.
	 *
	 * @param vlrd
	 *            the vlrd
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void insert(@NonNull final ValoracionDetalleVO vlrd) throws InstanceNotFoundException;

	/**
	 * Update.
	 *
	 * @param vlrd
	 *            the vlrd
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(@NonNull final ValoracionDetalleVO vlrd) throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param vlrd
	 *            the vlrd
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final ValoracionDetalleVO vlrd) throws InstanceNotFoundException;
}
