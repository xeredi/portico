package xeredi.argo.model.facturacion.vo;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaLineaCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class FacturaLineaCriterioVO extends BaseCriterioVO {

    /** The fctr. */
    private FacturaCriterioVO fctr = new FacturaCriterioVO();

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;
}
