package xeredi.integra.model.servicio.dao.manifiesto;


// TODO: Auto-generated Javadoc
/**
 * The Interface ManifiestoDAO.
 */
public interface ManifiestoServicioDAO {

    /**
     * Update bloquear.
     *
     * @param srvcId the srvc id
     * @return the int
     */
    int updateBloquear(final Long srvcId);

    /**
     * Update completar.
     *
     * @param srvcId the srvc id
     * @return the int
     */
    int updateCompletar(final Long srvcId);

    /**
     * Update iniciar.
     *
     * @param srvcId the srvc id
     * @return the int
     */
    int updateIniciar(final Long srvcId);

    /**
     * Update anular.
     *
     * @param srvcId the srvc id
     * @return the int
     */
    int updateAnular(final Long srvcId);

    /**
     * Update recalcular estado.
     *
     * @param srvcId the srvc id
     * @return the int
     */
    int updateRecalcularEstado(final Long srvcId);
}
