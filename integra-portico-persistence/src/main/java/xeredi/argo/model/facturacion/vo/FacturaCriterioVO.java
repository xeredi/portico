package xeredi.argo.model.facturacion.vo;

import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaCriterioVO.
 */
@Data
public final class FacturaCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The estado. */
    private FacturaEstado estado;

    /** The fcsr. */
    private FacturaServicioCriterioVO fcts;
}
