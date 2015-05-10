package xeredi.integra.model.gis.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MarkerOptionsVO.
 */
public final class MarkerOptionsVO {

    /** The title. */
    private String title;

    /** The icon. */
    private String icon;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public final String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param value
     *            the new title
     */
    public final void setTitle(final String value) {
        title = value;
    }

    /**
     * Gets the icon.
     *
     * @return the icon
     */
    public final String getIcon() {
        return icon;
    }

    /**
     * Sets the icon.
     *
     * @param value
     *            the new icon
     */
    public final void setIcon(final String value) {
        icon = value;
    }
}
