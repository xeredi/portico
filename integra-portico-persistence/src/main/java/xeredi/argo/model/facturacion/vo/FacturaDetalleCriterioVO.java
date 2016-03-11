package xeredi.argo.model.facturacion.vo;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetalleCriterioVO.
 */

/**
 * Instantiates a new factura detalle criterio vo.
 */

/**
 * Instantiates a new factura detalle criterio vo.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class FacturaDetalleCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The fctl id. */
    private Long fctlId;

    /** The vlrc id. */
    private Long vlrcId;

    /** The fctr id. */
    private Long fctrId;
}
