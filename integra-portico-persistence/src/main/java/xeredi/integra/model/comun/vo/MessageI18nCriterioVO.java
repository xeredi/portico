package xeredi.integra.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nCriterioVO.
 */
public final class MessageI18nCriterioVO {

    /** The internals only. */
    private boolean externalsOnly;

    /** The key. */
    private String key;

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
     * Checks if is externals only.
     *
     * @return true, if is externals only
     */
    public boolean isExternalsOnly() {
        return externalsOnly;
    }

    /**
     * Sets the externals only.
     *
     * @param value
     *            the new externals only
     */
    public void setExternalsOnly(final boolean value) {
        externalsOnly = value;
    }

}
