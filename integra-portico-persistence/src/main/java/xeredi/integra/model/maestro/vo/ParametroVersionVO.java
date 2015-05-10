package xeredi.integra.model.maestro.vo;

import xeredi.integra.model.comun.vo.VersionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroVersionVO.
 */
public final class ParametroVersionVO extends VersionVO {

    /** The lat. */
    private Double lat;

    /** The lon. */
    private Double lon;

    /**
     * Gets the lat.
     *
     * @return the lat
     */
    public final Double getLat() {
        return lat;
    }

    /**
     * Sets the lat.
     *
     * @param value
     *            the new lat
     */
    public final void setLat(final Double value) {
        lat = value;
    }

    /**
     * Gets the lon.
     *
     * @return the lon
     */
    public final Double getLon() {
        return lon;
    }

    /**
     * Sets the lon.
     *
     * @param value
     *            the new lon
     */
    public final void setLon(final Double value) {
        lon = value;
    }
}
