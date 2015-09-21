package xeredi.argo.model.comun.vo;

import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class I18nCriterioVO.
 */
public final class I18nCriterioVO extends BaseCriterioVO {
    /** The prefix. */
    private I18nPrefix prefix;

    /** The prefix set. */
    private Set<I18nPrefix> prefixSet;

    /** The external id. */
    private Long externalId;

    /** The language. */
    private String language;

    /** The default language. */
    private String defaultLanguage;

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
     * Gets the default language.
     *
     * @return the default language
     */
    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    /**
     * Sets the default language.
     *
     * @param value
     *            the new default language
     */
    public void setDefaultLanguage(final String value) {
        defaultLanguage = value;
    }

    /**
     * Gets the prefix set.
     *
     * @return the prefix set
     */
    public Set<I18nPrefix> getPrefixSet() {
        return prefixSet;
    }

    /**
     * Sets the prefix set.
     *
     * @param value
     *            the new prefix set
     */
    public void setPrefixSet(final Set<I18nPrefix> value) {
        prefixSet = value;
    }

}
