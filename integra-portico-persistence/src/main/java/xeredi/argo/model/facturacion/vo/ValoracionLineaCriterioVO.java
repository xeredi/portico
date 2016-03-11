package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ValoracionLineaCriterioVO extends BaseCriterioVO {

    /** The vlrc. */
    private Long vlrcId;

    /** The fctr id. */
    private Long fctrId;

    /** The id. */
    private Long id;

    /** The padre id. */
    private Long padreId;

    /** The solo hijos. */
    private boolean soloHijos;
}
