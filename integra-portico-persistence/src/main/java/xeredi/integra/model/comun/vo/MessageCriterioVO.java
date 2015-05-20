package xeredi.integra.model.comun.vo;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageCriterioVO.
 */
public final class MessageCriterioVO extends BaseCriterioVO {

    /** The key. */
    private MessageI18nKey key;

    /** The internal. */
    private Boolean internal;

    /**
     * Gets the internal.
     *
     * @return the internal
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

    /**
     * Gets the key.
     *
     * @return the key
     */
    public final MessageI18nKey getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param value
     *            the new key
     */
    public final void setKey(final MessageI18nKey value) {
        key = value;
    }

}
