package xeredi.integra.model.comun.vo;

// TODO: Auto-generated Javadoc
/**
 * The Enum ConfigurationKey.
 */
public enum ConfigurationKey {

    /** The language default. */
    LANGUAGE_DEFAULT("language.default"),

    /** The language available. */
    LANGUAGE_AVAILABLE("language.available"),

    FILTER_LIMIT("filter.limit"),

    ;

    /** The key. */
    String key;

    /**
     * Instantiates a new configuration key.
     *
     * @param key
     *            the key
     */
    private ConfigurationKey(final String key) {
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
