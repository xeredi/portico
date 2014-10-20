package xeredi.integra.model.comun.vo;

// TODO: Auto-generated Javadoc
/**
 * The Enum MessageI18nKey.
 */
public enum MessageI18nKey {

    /** The format date. */
    FORMAT_DATE("format_date"),
    /** The format datetime. */
    FORMAT_DATETIME("format_datetime");

    /** The key. */
    private String key;

    /**
     * Instantiates a new message i18n key.
     *
     * @param key
     *            the key
     */
    private MessageI18nKey(final String key) {
        this.key = key;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

}
