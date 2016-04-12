package xeredi.argo.model.estadistica.vo;

import java.util.Map;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class EurostatVO.
 */
@Data
public final class EurostatVO {

    /** The report. */
    private EurostatReport report;

    /** The year. */
    private Integer year;

    /** The quarter. */
    private Integer quarter;

    /** The port. */
    private String port;

    /** The map. */
    private Map<String, Object> map;

}
