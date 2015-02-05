package xeredi.integra.model.servicio.dao.manifiesto;

import javax.annotation.Nonnull;

// TODO: Auto-generated Javadoc
/**
 * The Interface ManifiestoDAO.
 */
public interface ManifiestoServicioDAO {

    /**
     * Update bloquear.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    int updateBloquear(final @Nonnull Long srvcId);

    /**
     * Update completar.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    int updateCompletar(final @Nonnull Long srvcId);

    /**
     * Update iniciar.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    int updateIniciar(final @Nonnull Long srvcId);

    /**
     * Update anular.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    int updateAnular(final @Nonnull Long srvcId);

    /**
     * Update recalcular estado.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    int updateRecalcularEstado(final @Nonnull Long srvcId);
}
