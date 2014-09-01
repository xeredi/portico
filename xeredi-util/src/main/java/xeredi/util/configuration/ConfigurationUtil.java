package xeredi.util.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationUtil.
 */
public final class ConfigurationUtil {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ConfigurationUtil.class);

    /** The Constant CONFIGURATION_FILENAME. */
    private static final String CONFIGURATION_FILENAME = "Configuration.properties";

    /** The CONFIGURATION. */
    private static Configuration configuration;

    /**
     * Instancia un nuevo configuration util.
     */
    private ConfigurationUtil() {
        super();
    }

    static {
        try {
            LOG.info("Loading configuration from " + CONFIGURATION_FILENAME);

            configuration = new PropertiesConfiguration(CONFIGURATION_FILENAME);

            LOG.info(CONFIGURATION_FILENAME + " load OK");
        } catch (final Exception ex) {
            LOG.error("Error loading configuration from " + CONFIGURATION_FILENAME);
            LOG.error("Pila", ex);
        }
    }

    /**
     * Gets the configuration.
     * 
     * @return the configuration
     */
    public static Configuration getConfiguration() {
        return configuration;
    }
}
