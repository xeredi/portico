package xeredi.integra.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nCriterioVO.
 */
public final class MessageI18nCriterioVO {
    /** The key. */
    private MessageI18nKey key;

    /** The language. */
    private String language;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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

}
