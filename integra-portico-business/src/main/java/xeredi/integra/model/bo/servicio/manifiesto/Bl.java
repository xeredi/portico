package xeredi.integra.model.bo.servicio.manifiesto;

import xeredi.integra.model.bo.servicio.EstadoInvalidoException;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesVO;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Bl.
 */
public interface Bl {

    /**
     * Completar.
     * 
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    void completar(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException;

    /**
     * Bloquear.
     * 
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    void bloquear(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException;

    /**
     * Iniciar.
     * 
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    void iniciar(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException;

    /**
     * Anular.
     * 
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    void anular(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException;

    /**
     * Select resumen.
     * 
     * @param maniId
     *            the mani id
     * @param blId
     *            the bl id
     * @return the resumen totales vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ResumenTotalesVO selectResumen(final Long maniId, final Long blId) throws InstanceNotFoundException;
}
