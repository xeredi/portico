package xeredi.argo.model.gis.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MarkerCoordsVO.
 */
public final class CoordsVO {

    /** The latitude. */
    private double latitude;

    /** The longitude. */
    private double longitude;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the latitude.
     *
     * @return the latitude
     */
    public final double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude.
     *
     * @param value
     *            the new latitude
     */
    public final void setLatitude(final double value) {
        latitude = value;
    }

    /**
     * Gets the longitude.
     *
     * @return the longitude
     */
    public final double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude.
     *
     * @param value
     *            the new longitude
     */
    public final void setLongitude(final double value) {
        longitude = value;
    }
}
