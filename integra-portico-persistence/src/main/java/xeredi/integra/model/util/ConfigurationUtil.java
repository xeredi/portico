package xeredi.integra.model.util;

import org.apache.commons.configuration.CombinedConfiguration;
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

    /** The CONFIGURATION. */
    private static CombinedConfiguration configuration;

    /**
     * Instancia un nuevo configuration util.
     */
    private ConfigurationUtil() {
        super();
    }

    static {
        try {
            String filename = null;

            LOG.info("Loading configuration");

            configuration = new CombinedConfiguration();

            filename = "Configuration.properties";
            LOG.info(filename);
            configuration.addConfiguration(new PropertiesConfiguration(filename));

            filename = "Configuration_env.properties";
            LOG.info(filename);
            configuration.addConfiguration(new PropertiesConfiguration(filename));

            LOG.info("Loading configuration OK");
        } catch (final Exception ex) {
            LOG.fatal("Loading configuration Error", ex);
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
