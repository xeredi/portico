package xeredi.util.memcached;

import xeredi.util.exception.InternalErrorException;

// TODO: Auto-generated Javadoc
/**
 * The Class MemcachedClientUtil.
 */
public class MemcachedClientUtil {

    /**
     * Instantiates a new memcached client util.
     */
    private MemcachedClientUtil() {
        super();
    }

    /**
     * Sets the.
     * 
     * @param key
     *            the key
     * @param exp
     *            the exp
     * @param value
     *            the value
     * @return true, if successful
     * @throws InternalErrorException
     *             the internal error exception
     */
    public static boolean set(final String key, final int exp, final Object value) throws InternalErrorException {
        try {
            return MemcachedClientLocator.getMemcachedClient().set(key, exp, value);
        } catch (final Exception ex) {
            throw new InternalErrorException(ex);
        }
    }
}
