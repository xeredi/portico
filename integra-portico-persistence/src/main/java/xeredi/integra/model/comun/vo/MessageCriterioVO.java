package xeredi.integra.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageCriterioVO.
 */
public final class MessageCriterioVO {

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

}
