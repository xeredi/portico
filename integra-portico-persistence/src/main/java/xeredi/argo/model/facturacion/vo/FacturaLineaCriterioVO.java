package xeredi.argo.model.facturacion.vo;

import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaLineaCriterioVO.
 */
@Data
public final class FacturaLineaCriterioVO extends BaseCriterioVO {

    /** The fctr. */
    private FacturaCriterioVO fctr;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;
}
