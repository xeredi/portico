package xeredi.argo.model.gis.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MapOptionsVO.
 */
public final class MapOptionsVO {

    /** The scale control. */
    private Boolean scaleControl;

    /** The street view control. */
    private Boolean streetViewControl;

    /** The scrollwheel. */
    private Boolean scrollwheel;

    /** The min zoom. */
    private int minZoom;

    /** The max zoom. */
    private int maxZoom;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the scale control.
     *
     * @return the scale control
     */
    public final Boolean getScaleControl() {
        return scaleControl;
    }

    /**
     * Sets the scale control.
     *
     * @param value
     *            the new scale control
     */
    public final void setScaleControl(final Boolean value) {
        scaleControl = value;
    }

    /**
     * Gets the street view control.
     *
     * @return the street view control
     */
    public final Boolean getStreetViewControl() {
        return streetViewControl;
    }

    /**
     * Sets the street view control.
     *
     * @param value
     *            the new street view control
     */
    public final void setStreetViewControl(final Boolean value) {
        streetViewControl = value;
    }

    /**
     * Gets the scrollwheel.
     *
     * @return the scrollwheel
     */
    public final Boolean getScrollwheel() {
        return scrollwheel;
    }

    /**
     * Sets the scrollwheel.
     *
     * @param value
     *            the new scrollwheel
     */
    public final void setScrollwheel(final Boolean value) {
        scrollwheel = value;
    }

    /**
     * Gets the min zoom.
     *
     * @return the min zoom
     */
    public final int getMinZoom() {
        return minZoom;
    }

    /**
     * Sets the min zoom.
     *
     * @param value
     *            the new min zoom
     */
    public final void setMinZoom(final int value) {
        minZoom = value;
    }

    /**
     * Gets the max zoom.
     *
     * @return the max zoom
     */
    public final int getMaxZoom() {
        return maxZoom;
    }

    /**
     * Sets the max zoom.
     *
     * @param value
     *            the new max zoom
     */
    public final void setMaxZoom(final int value) {
        maxZoom = value;
    }
}
