package xeredi.argo.model.estadistica.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface PeriodoProcesoService.
 */
public interface PeriodoProcesoService {

	/**
	 * Exists.
	 *
	 * @param peprVO
	 *            the pepr VO
	 * @return true, if successful
	 */
	boolean exists(final PeriodoProcesoVO peprVO);

	/**
	 * Select.
	 *
	 * @param peprId
	 *            the pepr id
	 * @param idioma
	 *            the idioma
	 * @return the periodo proceso VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	PeriodoProcesoVO select(@NonNull final Long peprId, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param peprCriterioVO
	 *            the pepr criterio VO
	 * @return the list
	 */
	List<PeriodoProcesoVO> selectList(final PeriodoProcesoCriterioVO peprCriterioVO);

	/**
	 * Select list.
	 *
	 * @param peprCriterioVO
	 *            the pepr criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<PeriodoProcesoVO> selectList(@NonNull final PeriodoProcesoCriterioVO peprCriterioVO, final int offset,
			final int limit);

	/**
	 * Delete.
	 *
	 * @param pepr
	 *            the pepr
	 */
	void delete(@NonNull final PeriodoProcesoVO pepr);

	/**
	 * Generar cuadro mensual.
	 *
	 * @param peprId
	 *            the pepr id
	 * @param removeIfExists
	 *            the remove if exists
	 */
	void generarCuadroMensual(@NonNull final Long peprId, final boolean removeIfExists);

	/**
	 * Cargar archivo.
	 *
	 * @param pepr
	 *            the pepr
	 * @param prtoMap
	 *            the prto map
	 * @param estdList
	 *            the estd list
	 * @param removeIfExists
	 *            the remove if exists
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	void cargarArchivo(@NonNull final PeriodoProcesoVO pepr, @NonNull final Map<String, PuertoVO> prtoMap,
			@NonNull final List<EstadisticaVO> estdList, final boolean removeIfExists)
			throws DuplicateInstanceException;

	/**
	 * Agregar servicios.
	 *
	 * @param pepr
	 *            the pepr
	 * @param removeIfExists
	 *            the remove if exists
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	void agregarServicios(@NonNull final PeriodoProcesoVO pepr, final boolean removeIfExists)
			throws DuplicateInstanceException, IOException;
}
