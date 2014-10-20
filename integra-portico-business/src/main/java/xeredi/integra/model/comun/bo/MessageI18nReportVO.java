package xeredi.integra.model.comun.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nReportVO.
 */
public final class MessageI18nReportVO {

    /** The key list. */
    private final List<String> keyList;

    /** The language list. */
    private final List<String> languageList;

    /** The values map. */
    private final Map<String, Map<String, String>> valuesMap;

    /**
     * Instantiates a new message i18n report vo.
     *
     * @param akeyList
     *            the akey list
     * @param alanguageList
     *            the alanguage list
     */
    public MessageI18nReportVO(final List<String> akeyList, final List<String> alanguageList) {
        keyList = akeyList;
        languageList = alanguageList;
        valuesMap = new HashMap<>();

        for (final String key : keyList) {
            valuesMap.put(key, new HashMap<String, String>());
        }
    }

    /**
     * Gets the key list.
     *
     * @return the key list
     */
    public List<String> getKeyList() {
        return keyList;
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
    public Map<String, Map<String, String>> getValuesMap() {
        return valuesMap;
    }

}
