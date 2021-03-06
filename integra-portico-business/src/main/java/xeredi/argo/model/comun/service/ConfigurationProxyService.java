package xeredi.argo.model.comun.service;

import javax.inject.Inject;

import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.guice.transactional.Transactional;

import lombok.NonNull;
import xeredi.argo.model.comun.dao.ConfigurationDAO;
import xeredi.argo.model.comun.vo.ConfigurationCriterioVO;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationProxyService.
 */
public class ConfigurationProxyService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ConfigurationProxyService.class);

	/** The Constant CONFIGURATION_FILENAME. */
	public static final String CONFIGURATION_FILENAME = "Configuration_env.properties";

	/** The configuration. */
	private static final CombinedConfiguration configuration = new CombinedConfiguration();

	/** The conf DAO. */
	@Inject
	private ConfigurationDAO confDAO;

	/**
	 * Gets the string.
	 *
	 * @param key
	 *            the key
	 * @return the string
	 */
	public String getString(@NonNull final ConfigurationKey key) {
		return getConfiguration().getString(key.name());
	}

	/**
	 * Gets the string array.
	 *
	 * @param key
	 *            the key
	 * @return the string array
	 */
	public String[] getStringArray(@NonNull final ConfigurationKey key) {
		return getConfiguration().getStringArray(key.name());
	}

	/**
	 * Gets the int.
	 *
	 * @param key
	 *            the key
	 * @return the int
	 */
	public int getInt(@NonNull final ConfigurationKey key) {
		return getConfiguration().getInt(key.name());
	}

	/**
	 * Gets the boolean.
	 *
	 * @param key
	 *            the key
	 * @return the boolean
	 */
	public boolean getBoolean(@NonNull final ConfigurationKey key) {
		return getConfiguration().getBoolean(key.name());
	}

	/**
	 * Gets the configuration.
	 *
	 * @return the configuration
	 */
	private CombinedConfiguration getConfiguration() {
		if (configuration.isEmpty()) {
			loadConfiguration();
		}

		return configuration;
	}

	/**
	 * Load configuration.
	 */
	@Transactional
	private void loadConfiguration() {
		LOG.info("Loading Configuration");

		try {
			configuration.addConfiguration(new PropertiesConfiguration(CONFIGURATION_FILENAME));

			for (final ConfigurationVO vo : confDAO.selectList(new ConfigurationCriterioVO())) {
				configuration.addProperty(vo.getKey().name(),
						vo.getValue() == null ? vo.getDefaultValue() : vo.getValue());
			}
		} catch (final Throwable ex) {
			LOG.fatal("Error Loading Configuration", ex);

			throw new Error(ex);
		}
	}

}
