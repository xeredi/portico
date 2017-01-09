package xeredi.argo.http.controller.action.administracion.messagei18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.ListAction;
import xeredi.argo.model.comun.service.MessageI18nService;
import xeredi.argo.model.comun.vo.MessageI18nKey;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nListAction.
 */
public final class MessageI18nListAction extends ListAction<MessageI18nKey> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9186179634462884228L;

	/** The key map. */
	@Getter
	private Map<MessageI18nKey, Map<String, String>> keyMap;

	@Inject
	private MessageI18nService m18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() {
		resultList = m18nService.selectKeys();
		keyMap = new HashMap<MessageI18nKey, Map<String, String>>();

		for (final String language : getAvailableLanguages()) {
			final Map<MessageI18nKey, String> map = m18nService.selectLocaleMap(new Locale(language));

			for (final MessageI18nKey key : map.keySet()) {
				if (!keyMap.containsKey(key)) {
					keyMap.put(key, new HashMap<String, String>());
				}

				keyMap.get(key).put(language, map.get(key));
			}
		}
	}
}
