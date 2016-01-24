package xeredi.argo.model.gis.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class MapBoundsVO.
 */
@Data
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
}
