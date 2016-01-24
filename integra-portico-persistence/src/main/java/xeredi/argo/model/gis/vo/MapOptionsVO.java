package xeredi.argo.model.gis.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class MapOptionsVO.
 */
@Data
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
}
