package xeredi.integra.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nVO.
 */
public final class MessageI18nVO {

    /** The bundle. */
    private MessageI18nBundle bundle;

    /** The key. */
    private String key;

    /** The language. */
    private String language;

    /** The value. */
    private String value;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the bundle.
     *
     * @return the bundle
     */
    public MessageI18nBundle getBundle() {
        return bundle;
    }

    /**
     * Sets the bundle.
     *
     * @param value
     *            the new bundle
     */
    public void setBundle(final MessageI18nBundle value) {
        bundle = value;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param value
     *            the new key
     */
    public void setKey(final String value) {
        key = value;
    }

    /**
     * Gets the language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     *
     * @param value
     *            the new language
     */
    public void setLanguage(final String value) {
        language = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value
     *            the new value
     */
    public void setValue(final String value) {
        this.value = value;
    }

}
