package xeredi.integra.model.gis.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MapVO.
 */
public final class MapVO {

    /** The center. */
    private final MapCenterVO center;

    /** The zoom. */
    private int zoom;

    /** The marker list. */
    private final List<MarkerVO> markerList;

    /**
     * Instantiates a new map vo.
     */
    public MapVO() {
        super();

        center = new MapCenterVO();
        markerList = new ArrayList<MarkerVO>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the marker list.
     *
     * @return the marker list
     */
    public final List<MarkerVO> getMarkerList() {
        return markerList;
    }

    /**
     * Gets the center.
     *
     * @return the center
     */
    public final MapCenterVO getCenter() {
        return center;
    }

    /**
     * Gets the zoom.
     *
     * @return the zoom
     */
    public final int getZoom() {
        return zoom;
    }

    /**
     * Sets the zoom.
     *
     * @param value
     *            the new zoom
     */
    public final void setZoom(final int value) {
        zoom = value;
    }
}
