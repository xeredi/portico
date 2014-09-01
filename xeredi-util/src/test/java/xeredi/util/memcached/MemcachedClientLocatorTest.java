package xeredi.util.memcached;

import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xeredi.util.exception.InternalErrorException;

// TODO: Auto-generated Javadoc
/**
 * The Class MemcachedClientLocatorTest.
 */
public final class MemcachedClientLocatorTest {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(MemcachedClientLocatorTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Test Start");

        Boolean value = Boolean.FALSE;

        try {
            final MemcachedClient client = MemcachedClientLocator.getMemcachedClient();

            client.set("testKey", 1000, Boolean.FALSE);

            value = (Boolean) client.get("testKeyBad");
            value = (Boolean) client.get("testKey");
        } catch (final InternalErrorException ex) {
            LOG.error(ex.getMessage(), ex);
        } catch (final TimeoutException ex) {
            LOG.error(ex.getMessage(), ex);
        } catch (final InterruptedException ex) {
            LOG.error(ex.getMessage(), ex);
        } catch (final MemcachedException ex) {
            LOG.error(ex.getMessage(), ex);
        }

        LOG.info("Test End");

    }
}
