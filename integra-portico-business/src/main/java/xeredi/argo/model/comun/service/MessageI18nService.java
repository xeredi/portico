package xeredi.argo.model.comun.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.MessageI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageI18nService.
 */
public interface MessageI18nService {

	/**
	 * Select keys.
	 *
	 * @return the list
	 */
	List<MessageI18nKey> selectKeys();

	/**
	 * Select locale map.
	 *
	 * @param locale
	 *            the locale
	 * @return the map
	 */
	Map<MessageI18nKey, String> selectLocaleMap(final Locale locale);

	/**
	 * Select key map.
	 *
	 * @param key
	 *            the key
	 * @return the map
	 */
	Map<String, MessageI18nVO> selectKeyMap(@NonNull final MessageI18nKey key);

	/**
	 * Update key map.
	 *
	 * @param key
	 *            the key
	 * @param map
	 *            the map
	 */
	void updateKeyMap(@NonNull final MessageI18nKey key, @NonNull final Map<String, MessageI18nVO> map);
}
