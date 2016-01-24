package xeredi.argo.model.gis.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class MarkerVO.
 */
@Data
public final class MarkerVO {

    /** The id. */
    private Long id;

    /** The coords. */
    private final CoordsVO coords;

    /** The options. */
    private final MarkerOptionsVO options;

    /** The window options. */
    private final WindowOptionsVO windowOptions;

    /**
     * Instantiates a new marker vo.
     */
    public MarkerVO() {
        super();

        coords = new CoordsVO();
        options = new MarkerOptionsVO();
        windowOptions = new WindowOptionsVO();
    }
}
