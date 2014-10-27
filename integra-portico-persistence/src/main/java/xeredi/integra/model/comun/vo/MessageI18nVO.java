package xeredi.integra.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nVO.
 */
public final class MessageI18nVO {

    /** The key. */
    private MessageI18nKey key;

    /** The language. */
    private String language;

    /** The internal. */
    private boolean internal;

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
     * Checks if is internal.
     *
     * @return true, if is internal
     */
    public boolean isInternal() {
        return internal;
    }

    /**
     * Sets the internal.
     *
     * @param value
     *            the new internal
     */
    public void setInternal(final boolean value) {
        internal = value;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public MessageI18nKey getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param value
     *            the new key
     */
    public void setKey(final MessageI18nKey value) {
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
