package xeredi.argo.model.proceso.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoItemCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ProcesoItemCriterioVO extends BaseCriterioVO {

    /** The prbt id. */
    private Long prbtId;

    /** The sentido. */
    private ItemSentido sentido;
}
