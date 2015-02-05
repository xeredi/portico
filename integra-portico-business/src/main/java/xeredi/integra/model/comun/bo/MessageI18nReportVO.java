package xeredi.integra.model.comun.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.vo.MessageI18nKey;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nReportVO.
 */
public final class MessageI18nReportVO {
    /** The language list. */
    private final List<String> languageList;

    /** The values map. */
    private final Map<MessageI18nKey, Map<String, String>> valuesMap;

    /**
     * Instantiates a new message i18n report vo.
     *
     * @param alanguageList
     *            the alanguage list
     */
    public MessageI18nReportVO(final @Nonnull List<String> alanguageList) {
        languageList = alanguageList;
        valuesMap = new HashMap<>();

        for (final MessageI18nKey key : MessageI18nKey.values()) {
            valuesMap.put(key, new HashMap<String, String>());
        }
    }

    /**
     * Gets the key list.
     *
     * @return the key list
     */
    public MessageI18nKey[] getKeys() {
        return MessageI18nKey.values();
    }

    /**
     * Gets the language list.
     *
     * @return the language list
     */
    public List<String> getLanguageList() {
        return languageList;
    }

    /**
     * Gets the values map.
     *
     * @return the values map
     */
    public Map<MessageI18nKey, Map<String, String>> getValuesMap() {
        return valuesMap;
    }

}
