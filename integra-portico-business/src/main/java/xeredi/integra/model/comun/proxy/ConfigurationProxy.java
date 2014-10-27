package xeredi.integra.model.comun.proxy;

import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.bo.ConfigurationBO;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationProxy.
 */
public final class ConfigurationProxy {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ConfigurationProxy.class);

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
            configuration.addConfiguration(new PropertiesConfiguration("Configuration_env.properties"));

            final ConfigurationBO confBO = new ConfigurationBO();

            for (final ConfigurationVO vo : confBO.selectList()) {
                configuration.addProperty(vo.getKey().name(),
                        vo.getValue() == null ? vo.getDefaultValue() : vo.getValue());
            }
        } catch (final Throwable ex) {
            LOG.fatal("Error Loading Configuration", ex);
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
    public static String getString(final ConfigurationKey key) {
        return configuration.getString(key.name());
    }

    /**
     * Gets the string array.
     *
     * @param key
     *            the key
     * @return the string array
     */
    public static String[] getStringArray(final ConfigurationKey key) {
        return configuration.getStringArray(key.name());
    }

    /**
     * Gets the int.
     *
     * @param key
     *            the key
     * @return the int
     */
    public static int getInt(final ConfigurationKey key) {
        return configuration.getInt(key.name());
    }

}
