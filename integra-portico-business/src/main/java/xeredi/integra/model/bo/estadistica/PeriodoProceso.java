package xeredi.integra.model.bo.estadistica;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import xeredi.integra.model.vo.estadistica.EstadisticaVO;
import xeredi.integra.model.vo.estadistica.PeriodoProcesoCriterioVO;
import xeredi.integra.model.vo.estadistica.PeriodoProcesoVO;
import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface PeriodoProceso.
 */
public interface PeriodoProceso {

    /**
     * Exists.
     * 
     * @param peprVO
     *            the pepr vo
     * @return true, if successful
     */
    boolean exists(final PeriodoProcesoVO peprVO);

    /**
     * Select.
     * 
     * @param peprId
     *            the pepr id
     * @return the periodo proceso vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    PeriodoProcesoVO select(final Long peprId) throws InstanceNotFoundException;

    /**
     * Select list.
     * 
     * @param peprCriterioVO
     *            the pepr criterio vo
     * @return the list
     */
    List<PeriodoProcesoVO> selectList(final PeriodoProcesoCriterioVO peprCriterioVO);

    /**
     * Select list.
     * 
     * @param peprCriterioVO
     *            the pepr criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<PeriodoProcesoVO> selectList(final PeriodoProcesoCriterioVO peprCriterioVO, final int offset,
            final int limit);

    /**
     * Delete.
     * 
     * @param peprId
     *            the pepr id
     */
    void delete(final Long peprId);

    /**
     * Cargar archivo.
     * 
     * @param peprVO
     *            the pepr vo
     * @param autpMap
     *            the autp map
     * @param estdList
     *            the estd list
     * @param removeIfExists
     *            the remove if exists
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void cargarArchivo(final PeriodoProcesoVO peprVO, final Map<String, ParametroVO> autpMap,
            final List<EstadisticaVO> estdList, final boolean removeIfExists) throws DuplicateInstanceException;

    /**
     * Agregar servicios.
     * 
     * @param peprVO
     *            the pepr vo
     * @param removeIfExists
     *            the remove if exists
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    void agregarServicios(final PeriodoProcesoVO peprVO, final boolean removeIfExists)
            throws DuplicateInstanceException, IOException;
}
