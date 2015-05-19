package xeredi.integra.model.comun.dao;

// TODO: Auto-generated Javadoc
/**
 * The Interface CrudVersionableDAO.
 *
 * @param <T>
 *            the generic type
 */
public interface CrudVersionableDAO<T> {

    /**
     * Exists overlap.
     *
     * @param t
     *            the t
     * @return true, if successful
     */
    boolean existsOverlap(final T t);

    /**
     * Insert version.
     *
     * @param t
     *            the t
     */
    void insertVersion(final T t);

    /**
     * Update version.
     *
     * @param t
     *            the t
     * @return the int
     */
    int updateVersion(final T t);

    /**
     * Delete version.
     *
     * @param t
     *            the t
     * @return the int
     */
    int deleteVersion(final T t);
}
