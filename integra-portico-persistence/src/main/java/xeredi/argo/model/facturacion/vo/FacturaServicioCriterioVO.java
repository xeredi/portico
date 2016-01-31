package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaServicioCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class FacturaServicioCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The fctr id. */
    private Long fctrId;

    /** The srvc id. */
    private Long srvcId;
}
