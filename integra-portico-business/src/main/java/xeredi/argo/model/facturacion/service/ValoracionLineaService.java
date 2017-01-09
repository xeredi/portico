package xeredi.argo.model.facturacion.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionLineaService.
 */
public interface ValoracionLineaService {

	/**
	 * Select object.
	 *
	 * @param vlrlCriterio
	 *            the vlrl criterio
	 * @return the valoracion linea VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	ValoracionLineaVO selectObject(@NonNull final ValoracionLineaCriterioVO vlrlCriterio)
			throws InstanceNotFoundException;

	/**
	 * Exists hija.
	 *
	 * @param vlrlId
	 *            the vlrl id
	 * @return true, if successful
	 */
	boolean existsHija(@NonNull final Long vlrlId);

	/**
	 * Select list.
	 *
	 * @param vlrlCriterio
	 *            the vlrl criterio
	 * @return the list
	 */
	List<ValoracionLineaVO> selectList(@NonNull final ValoracionLineaCriterioVO vlrlCriterio);

	/**
	 * Select list.
	 *
	 * @param vlrlCriterio
	 *            the vlrl criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<ValoracionLineaVO> selectList(@NonNull final ValoracionLineaCriterioVO vlrlCriterio, final int offset,
			final int limit);

	/**
	 * Alta de una linea de valoracion y su primer detalle de valoracion
	 * asociado. Validaciones de negocio:
	 *
	 * <ul>
	 * <li>La linea ha de estar asociada a una valoracion</li>
	 * <li>La linea ha de tener una regla</li>
	 * <li>La linea ha de tener un impuesto</li>
	 * <li>El detalle ha de tener importe base e importe</li>
	 * <li>La valoracion asociada a la linea debe existir</li>
	 * <li>La regla ha de ser valida para el aspecto de la valoracion asociada a
	 * la linea</li>
	 * <li>Si la regla está asociada a subservicios y el aspecto es de
	 * agrupacion, se comprueba que la linea tenga un subservicio asociado, y
	 * que sea de la misma entidad que la regla</li>
	 * <li>Si la regla está asociada a subservicios y el aspecto no es de
	 * agrupacion, se comprueba que el detalle tenga un subservicio asociado, y
	 * que sea de la misma entidad que la regla</li>
	 * <li>Si la regla no es de tipo precio, la linea ha de estar asociada a una
	 * linea padre</li>
	 * </ul>
	 *
	 * @param vlrl
	 *            Datos de una linea de valoracion.
	 */
	void insert(@NonNull final ValoracionLineaVO vlrl);

	/**
	 * Update.
	 *
	 * @param vlrl
	 *            the vlrl
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(@NonNull final ValoracionLineaVO vlrl) throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param vlrl
	 *            the vlrl
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final ValoracionLineaVO vlrl) throws InstanceNotFoundException;
}
