package xeredi.argo.model.proceso.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OperacionNoPermitidaException;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;
import xeredi.argo.model.proceso.vo.ProcesoMensajeCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoMensajeVO;
import xeredi.argo.model.proceso.vo.ProcesoParametroVO;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.proceso.vo.ProcesoVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoService.
 */
public interface ProcesoService {

	/**
	 * Crear.
	 *
	 * @param usroId
	 *            the usro id
	 * @param tipo
	 *            the tipo
	 * @param parametroMap
	 *            the parametro map
	 * @param itemEntradaTipo
	 *            the item entrada tipo
	 * @param itemEntradaList
	 *            the item entrada list
	 * @return the proceso VO
	 */
	ProcesoVO crear(@NonNull final Long usroId, @NonNull final ProcesoTipo tipo, final Map<String, String> parametroMap,
			final ItemTipo itemEntradaTipo, final List<Long> itemEntradaList);

	/**
	 * Proteger.
	 *
	 * @param tipo
	 *            the tipo
	 * @return the proceso VO
	 */
	ProcesoVO proteger(@NonNull final ProcesoTipo tipo);

	/**
	 * Finalizar.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @param prmnList
	 *            the prmn list
	 * @param itemSalidaTipo
	 *            the item salida tipo
	 * @param itemSalidaList
	 *            the item salida list
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OperacionNoPermitidaException
	 *             the operacion no permitida exception
	 */
	void finalizar(@NonNull final Long prbtId, final List<ProcesoMensajeVO> prmnList, final ItemTipo itemSalidaTipo,
			final List<Long> itemSalidaList) throws InstanceNotFoundException, OperacionNoPermitidaException;

	/**
	 * Cancelar.
	 *
	 * @param prbt
	 *            the prbt
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OperacionNoPermitidaException
	 *             the operacion no permitida exception
	 */
	void cancelar(@NonNull final ProcesoVO prbt) throws InstanceNotFoundException, OperacionNoPermitidaException;

	/**
	 * Select list.
	 *
	 * @param prbtCriterioVO
	 *            the prbt criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<ProcesoVO> selectList(@NonNull final ProcesoCriterioVO prbtCriterioVO, final int offset,
			final int limit);

	/**
	 * Select list.
	 *
	 * @param prbtCriterioVO
	 *            the prbt criterio VO
	 * @return the list
	 */
	List<ProcesoVO> selectList(@NonNull final ProcesoCriterioVO prbtCriterioVO);

	/**
	 * Select.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the proceso VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	ProcesoVO select(@NonNull final Long prbtId) throws InstanceNotFoundException;

	/**
	 * Select prmn list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<ProcesoMensajeVO> selectPrmnList(@NonNull final ProcesoMensajeCriterioVO criterio, final int offset,
			final int limit);

	/**
	 * Select prpm map.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the map
	 */
	Map<String, ProcesoParametroVO> selectPrpmMap(@NonNull final Long prbtId);

	/**
	 * Select arin entrada list.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the list
	 */
	List<ArchivoInfoVO> selectArinEntradaList(@NonNull final Long prbtId);

	/**
	 * Select arin salida list.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the list
	 */
	List<ArchivoInfoVO> selectArinSalidaList(@NonNull final Long prbtId);

	/**
	 * Select prit entrada list.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the list
	 */
	List<ProcesoItemVO> selectPritEntradaList(@NonNull final Long prbtId);

	/**
	 * Select prit salida list.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the list
	 */
	List<ProcesoItemVO> selectPritSalidaList(@NonNull final Long prbtId);
}
