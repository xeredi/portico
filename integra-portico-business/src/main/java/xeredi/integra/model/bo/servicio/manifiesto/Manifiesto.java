package xeredi.integra.model.bo.servicio.manifiesto;

import xeredi.integra.model.bo.servicio.EstadoInvalidoException;
import xeredi.integra.model.vo.servicio.manifiesto.ResumenTotalesVO;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Manifiesto.
 */
public interface Manifiesto {

    /**
     * Bloquear.
     * 
     * @param srvcId
     *            the srvc id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    void bloquear(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException;

    /**
     * Completar.
     * 
     * @param srvcId
     *            the srvc id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    void completar(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException;

    /**
     * Iniciar.
     * 
     * @param srvcId
     *            the srvc id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    void iniciar(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException;

    /**
     * Anular.
     * 
     * @param srvcId
     *            the srvc id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    void anular(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException;

    /**
     * Select resumen.
     * 
     * @param maniId
     *            the mani id
     * @return the resumen totales vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ResumenTotalesVO selectResumen(final Long maniId) throws InstanceNotFoundException;
}
