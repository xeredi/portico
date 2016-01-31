package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class FacturaSerieCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The anio. */
    private Integer anio;
}
