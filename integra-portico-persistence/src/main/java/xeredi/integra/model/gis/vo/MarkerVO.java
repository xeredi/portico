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
    private final CoordsVO coords;

    /** The options. */
    private final MarkerOptionsVO options;

    /**
     * Instantiates a new marker vo.
     */
    public MarkerVO() {
        super();

        coords = new CoordsVO();
        options = new MarkerOptionsVO();
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
    public final CoordsVO getCoords() {
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

    /**
     * Gets the options.
     *
     * @return the options
     */
    public final MarkerOptionsVO getOptions() {
        return options;
    }
}
