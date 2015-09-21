package xeredi.argo.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageVO.
 */
public final class MessageVO {

    /** The key. */
    private MessageI18nKey key;

    /** The internal. */
    private Boolean internal;

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
     * Checks if is internal.
     *
     * @return true, if is internal
     */
    public Boolean getInternal() {
        return internal;
    }

    /**
     * Sets the internal.
     *
     * @param value
     *            the new internal
     */
    public void setInternal(final Boolean value) {
        internal = value;
    }

}
