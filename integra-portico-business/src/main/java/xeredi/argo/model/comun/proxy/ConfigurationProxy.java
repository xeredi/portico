package xeredi.argo.model.comun.proxy;

import lombok.NonNull;

import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.argo.model.comun.bo.ConfigurationBO;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationProxy.
 */
public final class ConfigurationProxy {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ConfigurationProxy.class);

    /** The Constant CONFIGURATION_FILENAME. */
    public static final String CONFIGURATION_FILENAME = "Configuration_env.properties";

    /** The configuration. */
    private static CombinedConfiguration configuration;

    static {
        load();
    }

    /**
     * Load.
     */
    private static synchronized void load() {
        LOG.info("Loading Configuration");

        configuration = new CombinedConfiguration();

        try {
            configuration.addConfiguration(new PropertiesConfiguration(CONFIGURATION_FILENAME));

            final ConfigurationBO confBO = new ConfigurationBO();

            for (final ConfigurationVO vo : confBO.selectList()) {
                configuration.addProperty(vo.getKey().name(),
                        vo.getValue() == null ? vo.getDefaultValue() : vo.getValue());
            }
        } catch (final Throwable ex) {
            LOG.fatal("Error Loading Configuration", ex);

            throw new Error(ex);
        }
    }

    /**
     * Reload.
     */
    public static void reload() {
        LOG.info("Configuration Reload");

        load();
    }

    /**
     * Gets the string.
     *
     * @param key
     *            the key
     * @return the string
     */
    public static String getString(final @NonNull ConfigurationKey key) {
        return configuration.getString(key.name());
    }

    /**
     * Gets the string array.
     *
     * @param key
     *            the key
     * @return the string array
     */
    public static String[] getStringArray(final @NonNull ConfigurationKey key) {
        return configuration.getStringArray(key.name());
    }

    /**
     * Gets the int.
     *
     * @param key
     *            the key
     * @return the int
     */
    public static int getInt(final @NonNull ConfigurationKey key) {
        return configuration.getInt(key.name());
    }

}
