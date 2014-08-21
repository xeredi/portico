package xeredi.integra.model.servicio.bo.manifiesto;

import xeredi.integra.model.servicio.bo.EstadoInvalidoException;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Partida.
 */
public interface Partida {

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
