package xeredi.argo.model.estadistica.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.item.vo.ItemCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaCriterioVO.
 */
@Data
public final class EstadisticaCriterioVO extends ItemCriterioVO {

    /** The pepr id. */
    private PeriodoProcesoCriterioVO pepr;

    /** The subp id. */
    private PuertoCriterioVO prto;
}
