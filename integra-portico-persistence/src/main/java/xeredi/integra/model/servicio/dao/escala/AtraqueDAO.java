package xeredi.integra.model.servicio.dao.escala;


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
    boolean isAutorizable(final Long ssrvId);

    /**
     * Update autorizar.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    int updateAutorizar(final Long ssrvId);

    /**
     * Checks if is denegable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is denegable
     */
    boolean isDenegable(final Long ssrvId);

    /**
     * Update denegar.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    int updateDenegar(final Long ssrvId);

    /**
     * Checks if is anulable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is anulable
     */
    boolean isAnulable(final Long ssrvId);

    /**
     * Update anular.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    int updateAnular(final Long ssrvId);

    /**
     * Checks if is iniciable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is iniciable
     */
    boolean isIniciable(final Long ssrvId);

    /**
     * Update iniciar.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    int updateIniciar(final Long ssrvId);

    /**
     * Checks if is finalizable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is finalizable
     */
    boolean isFinalizable(final Long ssrvId);

    /**
     * Update finalizar.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    int updateFinalizar(final Long ssrvId);

    /**
     * Checks if is cambio muelle.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is cambio muelle
     */
    boolean isCambioMuelle(final Long ssrvId);

    /**
     * Checks if is autorizable f previo.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is autorizable f previo
     */
    boolean isAutorizableFprevio(final Long ssrvId);
}
