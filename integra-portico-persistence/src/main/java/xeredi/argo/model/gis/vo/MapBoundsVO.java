package xeredi.argo.model.gis.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MapBoundsVO.
 */
public final class MapBoundsVO {

    /** The northeast. */
    private final CoordsVO northeast;

    /** The southwest. */
    private final CoordsVO southwest;

    /**
     * Instantiates a new map bounds vo.
     */
    public MapBoundsVO() {
        super();

        northeast = new CoordsVO();
        southwest = new CoordsVO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the northeast.
     *
     * @return the northeast
     */
    public final CoordsVO getNortheast() {
        return northeast;
    }

    /**
     * Gets the southwest.
     *
     * @return the southwest
     */
    public final CoordsVO getSouthwest() {
        return southwest;
    }
}
