package xeredi.argo.model.estadistica.vo;

import lombok.Data;

/**
 * Instantiates a new chart vo.
 */
@Data
public final class ChartVO {

    /** The type. */
    private ChartType type;

    /** The options. */
    private ChartOptionsVO options = new ChartOptionsVO();

    /** The data. */
    private ChartDataVO data = new ChartDataVO();
}
