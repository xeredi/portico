package xeredi.argo.model.comun.dao;

// TODO: Auto-generated Javadoc
/**
 * The Interface CrudKeyDAO.
 *
 * @param <K>
 *            the key type
 * @param <T>
 *            the generic type
 */
public interface CrudKeyDAO<K, T> {

    /**
     * Select.
     *
     * @param key
     *            the key
     * @return the t
     */
    T select(final K key);
}
