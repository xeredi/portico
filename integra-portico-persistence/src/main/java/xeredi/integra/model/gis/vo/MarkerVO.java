package xeredi.integra.model.gis.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MarkerVO.
 */
public final class MarkerVO {

    /** The id. */
    private Long id;

    /** The coords. */
    private final MarkerCoordsVO coords;

    /**
     * Instantiates a new marker vo.
     */
    public MarkerVO() {
        super();

        coords = new MarkerCoordsVO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the coords.
     *
     * @return the coords
     */
    public final MarkerCoordsVO getCoords() {
        return coords;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    public final void setId(final Long value) {
        id = value;
    }
}
