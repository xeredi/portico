package xeredi.argo.model.servicio.dao.escala;

// TODO: Auto-generated Javadoc
/**
 * The Interface AtraqueDAO.
 */
public interface AtraqueDAO {
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
