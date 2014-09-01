package xeredi.util.memcached;

import java.io.IOException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xeredi.util.configuration.ConfigurationUtil;
import xeredi.util.exception.InternalErrorException;

// TODO: Auto-generated Javadoc
/**
 * The Class MemcachedLocator.
 */
public final class MemcachedClientLocator {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(MemcachedClientLocator.class);

    /** The Constant MEMCACHED_SERVER_URL_PARAMNAME. */
    private static final String MEMCACHED_SERVER_URL_PARAMNAME = "memcached.server.url";

    /** The memcached client. */
    private static MemcachedClient MEMCACHED_CLIENT;

    /**
     * Instantiates a new memcached locator.
     */
    private MemcachedClientLocator() {
        super();

    }

    /**
     * Gets the memcached client.
     * 
     * @return the memcached client
     * @throws InternalErrorException
     *             the internal error exception
     */
    public static MemcachedClient getMemcachedClient() throws InternalErrorException {
        if (MEMCACHED_CLIENT == null) {
            LOG.info("Creacion del cliente Memcached");

            final String memcachedServerUrl = ConfigurationUtil.getConfiguration().getString(
                    MEMCACHED_SERVER_URL_PARAMNAME);

            if (memcachedServerUrl == null) {
                final String errorMessage = "Parametro de configuracion no encontrado : "
                        + MEMCACHED_SERVER_URL_PARAMNAME;

                LOG.error(errorMessage);
                throw new InternalErrorException(new Exception(errorMessage));
            }

            final MemcachedClientBuilder builder = new XMemcachedClientBuilder(
                    AddrUtil.getAddresses(memcachedServerUrl));

            try {
                MEMCACHED_CLIENT = builder.build();
            } catch (final IOException ex) {
                LOG.error("Error construyendo el cliente memcached", ex);

                throw new InternalErrorException(ex);
            }

            LOG.info("Creacion del cliente Memcached OK");
        }

        return MEMCACHED_CLIENT;
    }
}