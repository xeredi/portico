package xeredi.argo.model.comun.proxy;

import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.NonNull;
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

	/**
	 * Instantiates a new configuration proxy.
	 */
	private ConfigurationProxy() {
		super();
	}

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
	 * Gets the string.
	 *
	 * @param key
	 *            the key
	 * @return the string
	 */
	public static String getString(@NonNull final ConfigurationKey key) {
		return configuration.getString(key.name());
	}

	/**
	 * Gets the string array.
	 *
	 * @param key
	 *            the key
	 * @return the string array
	 */
	public static String[] getStringArray(@NonNull final ConfigurationKey key) {
		return configuration.getStringArray(key.name());
	}

	/**
	 * Gets the int.
	 *
	 * @param key
	 *            the key
	 * @return the int
	 */
	public static int getInt(@NonNull final ConfigurationKey key) {
		return configuration.getInt(key.name());
	}

	/**
	 * Gets the boolean.
	 *
	 * @param key
	 *            the key
	 * @return the boolean
	 */
	public static boolean getBoolean(@NonNull final ConfigurationKey key) {
		return configuration.getBoolean(key.name());
	}

}
