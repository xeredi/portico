package xeredi.integra.http.controller.action.administracion.messagei18n;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.I18nJs;
import xeredi.integra.model.comun.bo.MessageBO;
import xeredi.integra.model.comun.vo.MessageI18nKey;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nListAction.
 */
public final class MessageI18nListAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9186179634462884228L;

    /** The report. */
    private List<MessageI18nKey> keyList;

    /** The key map. */
    private Map<MessageI18nKey, Map<String, String>> keyMap;

    /**
     * List.
     *
     * @return the string
     */
    @Action("m18n-grid")
    public String list() {
        final MessageBO mesgBO = new MessageBO();

        keyList = mesgBO.selectKeys();
        keyMap = new HashMap<MessageI18nKey, Map<String, String>>();

        for (final String language : getAvailableLanguages()) {
            final Map<MessageI18nKey, String> map = mesgBO.selectLocaleMap(new Locale(language));

            for (final MessageI18nKey key : map.keySet()) {
                if (!keyMap.containsKey(key)) {
                    keyMap.put(key, new HashMap<String, String>());
                }

                keyMap.get(key).put(language, map.get(key));
            }
        }

        return SUCCESS;
    }

    /**
     * Reload.
     *
     * @return the string
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Action("m18n-reload")
    public String reload() throws IOException {
        final I18nJs i18nJs = new I18nJs();

        i18nJs.export();

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the key list.
     *
     * @return the key list
     */
    public List<MessageI18nKey> getKeyList() {
        return keyList;
    }

    /**
     * Gets the key map.
     *
     * @return the key map
     */
    public Map<MessageI18nKey, Map<String, String>> getKeyMap() {
        return keyMap;
    }

}
