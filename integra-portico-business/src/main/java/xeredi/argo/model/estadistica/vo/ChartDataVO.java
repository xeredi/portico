package xeredi.argo.model.estadistica.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new chart data vo.
 */

/**
 * Instantiates a new chart data vo.
 */
@Data
public final class ChartDataVO {

    /** The cols. */
    private List<ChartColumnVO> cols = new ArrayList<>();

    /** The rows. */
    private List<ChartRowVO> rows = new ArrayList<>();
}
