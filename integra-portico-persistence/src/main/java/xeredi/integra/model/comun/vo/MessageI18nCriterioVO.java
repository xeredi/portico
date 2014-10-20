package xeredi.integra.model.comun.vo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nCriterioVO.
 */
public final class MessageI18nCriterioVO {

    /** The bundle set. */
    private Set<MessageI18nBundlename> bundleSet;

    /** The bundle. */
    private MessageI18nBundlename bundle;

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
     * Gets the bundle.
     *
     * @return the bundle
     */
    public MessageI18nBundlename getBundle() {
        return bundle;
    }

    /**
     * Sets the bundle.
     *
     * @param value
     *            the new bundle
     */
    public void setBundle(final MessageI18nBundlename value) {
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
     * Gets the bundle set.
     *
     * @return the bundle set
     */
    public Set<MessageI18nBundlename> getBundleSet() {
        return bundleSet;
    }

    /**
     * Sets the bundle set.
     *
     * @param value
     *            the new bundle set
     */
    public void setBundleSet(final Set<MessageI18nBundlename> value) {
        bundleSet = value;
    }

}
