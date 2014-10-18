package xeredi.integra.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class I18nVO.
 */
public final class I18nVO {

    /** The prefix. */
    private I18nPrefix prefix;

    /** The external id. */
    private Long externalId;

    /** The language. */
    private String language;

    /** The text. */
    private String text;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the prefix.
     *
     * @return the prefix
     */
    public I18nPrefix getPrefix() {
        return prefix;
    }

    /**
     * Sets the prefix.
     *
     * @param value
     *            the new prefix
     */
    public void setPrefix(final I18nPrefix value) {
        prefix = value;
    }

    /**
     * Gets the external id.
     *
     * @return the external id
     */
    public Long getExternalId() {
        return externalId;
    }

    /**
     * Sets the external id.
     *
     * @param value
     *            the new external id
     */
    public void setExternalId(final Long value) {
        externalId = value;
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
     * Gets the text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param value
     *            the new text
     */
    public void setText(final String value) {
        text = value;
    }

}
