package xeredi.integra.model.servicio.dao.escala;

import javax.annotation.Nonnull;

// TODO: Auto-generated Javadoc
/**
 * The Interface AtraqueDAO.
 */
public interface AtraqueDAO {

    /**
     * Checks if is autorizable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is autorizable
     */
    boolean isAutorizable(final @Nonnull Long ssrvId);

    /**
     * Update autorizar.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    int updateAutorizar(final @Nonnull Long ssrvId);

    /**
     * Checks if is denegable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is denegable
     */
    boolean isDenegable(final @Nonnull Long ssrvId);

    /**
     * Update denegar.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    int updateDenegar(final @Nonnull Long ssrvId);

    /**
     * Checks if is anulable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is anulable
     */
    boolean isAnulable(final @Nonnull Long ssrvId);

    /**
     * Update anular.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    int updateAnular(final @Nonnull Long ssrvId);

    /**
     * Checks if is iniciable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is iniciable
     */
    boolean isIniciable(final @Nonnull Long ssrvId);

    /**
     * Update iniciar.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    int updateIniciar(final @Nonnull Long ssrvId);

    /**
     * Checks if is finalizable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is finalizable
     */
    boolean isFinalizable(final @Nonnull Long ssrvId);

    /**
     * Update finalizar.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    int updateFinalizar(final @Nonnull Long ssrvId);

    /**
     * Checks if is cambio muelle.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is cambio muelle
     */
    boolean isCambioMuelle(final @Nonnull Long ssrvId);

    /**
     * Checks if is autorizable f previo.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is autorizable f previo
     */
    boolean isAutorizableFprevio(final @Nonnull Long ssrvId);
}
