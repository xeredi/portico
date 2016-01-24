package xeredi.argo.model.facturacion.vo;

import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetalleCriterioVO.
 */
@Data
public final class FacturaDetalleCriterioVO extends BaseCriterioVO {

    /** The fctl. */
    private FacturaLineaCriterioVO fctl;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;
}
