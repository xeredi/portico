package xeredi.argo.model.comun.service;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.ConfigurationKey;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConfigurationProxyService.
 */
public interface ConfigurationProxyService {
	/**
	 * Gets the string.
	 *
	 * @param key
	 *            the key
	 * @return the string
	 */
	String getString(@NonNull final ConfigurationKey key);

	/**
	 * Gets the string array.
	 *
	 * @param key
	 *            the key
	 * @return the string array
	 */
	String[] getStringArray(@NonNull final ConfigurationKey key);

	/**
	 * Gets the int.
	 *
	 * @param key
	 *            the key
	 * @return the int
	 */
	int getInt(@NonNull final ConfigurationKey key);

	/**
	 * Gets the boolean.
	 *
	 * @param key
	 *            the key
	 * @return the boolean
	 */
	boolean getBoolean(@NonNull final ConfigurationKey key);

}
