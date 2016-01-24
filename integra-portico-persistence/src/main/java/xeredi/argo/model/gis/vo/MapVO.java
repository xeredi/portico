package xeredi.argo.model.gis.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class MapVO.
 */
@Data
public final class MapVO {

    /** The center. */
    private final CoordsVO center;

    /** The zoom. */
    private int zoom;

    /** The marker list. */
    private final List<MarkerVO> markerList;

    /** The options. */
    private final MapOptionsVO options;

    /** The bounds. */
    private final MapBoundsVO bounds;

    /**
     * Instantiates a new map vo.
     */
    public MapVO() {
        super();

        center = new CoordsVO();
        markerList = new ArrayList<MarkerVO>();
        options = new MapOptionsVO();
        bounds = new MapBoundsVO();
    }
}
