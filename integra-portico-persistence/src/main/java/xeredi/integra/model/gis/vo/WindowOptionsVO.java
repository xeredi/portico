package xeredi.integra.model.gis.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class WindowOptionsVO.
 */
public final class WindowOptionsVO {

    /** The visible. */
    private boolean visible;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Checks if is visible.
     *
     * @return true, if is visible
     */
    public final boolean isVisible() {
        return visible;
    }

    /**
     * Sets the visible.
     *
     * @param value
     *            the new visible
     */
    public final void setVisible(final boolean value) {
        visible = value;
    }
}
