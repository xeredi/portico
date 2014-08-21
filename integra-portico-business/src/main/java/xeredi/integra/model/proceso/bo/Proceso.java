package xeredi.integra.model.proceso.bo;

import java.util.List;

import xeredi.integra.model.proceso.vo.ProcesoCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Proceso.
 */
public interface Proceso {

    /**
     * Crear.
     * 
     * @param prbtVO
     *            the prbt vo
     */
    void crear(final ProcesoVO prbtVO);

    /**
     * Proteger.
     * 
     * @param modulo
     *            the modulo
     * @param tipo
     *            the tipo
     * @return the proceso vo
     */
    ProcesoVO proteger(final ProcesoModulo modulo, final ProcesoTipo tipo);

    /**
     * Finalizar.
     * 
     * @param prbtVO
     *            the prbt vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    void finalizar(final ProcesoVO prbtVO) throws InstanceNotFoundException, OperacionNoPermitidaException;

    /**
     * Cancelar.
     * 
     * @param prbtId
     *            the prbt id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    void cancelar(final Long prbtId) throws InstanceNotFoundException, OperacionNoPermitidaException;

    /**
     * Select list.
     * 
     * @param prbtCriterioVO
     *            the prbt criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<ProcesoVO> selectList(final ProcesoCriterioVO prbtCriterioVO, final int offset, final int limit);

    /**
     * Select list.
     * 
     * @param prbtCriterioVO
     *            the prbt criterio vo
     * @return the list
     */
    List<ProcesoVO> selectList(final ProcesoCriterioVO prbtCriterioVO);

    /**
     * Select.
     * 
     * @param prbtId
     *            the prbt id
     * @return the proceso vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ProcesoVO select(final Long prbtId) throws InstanceNotFoundException;
}
