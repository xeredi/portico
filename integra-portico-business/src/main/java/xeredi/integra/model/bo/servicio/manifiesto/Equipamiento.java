package xeredi.integra.model.bo.servicio.manifiesto;

import xeredi.integra.model.bo.servicio.EstadoInvalidoException;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Equipamiento.
 */
public interface Equipamiento {

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
}
