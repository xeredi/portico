package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleCriterioVO.
 */
@Data
public final class ValoracionDetalleCriterioVO extends BaseCriterioVO {

    /** The vlrl. */
    private ValoracionLineaCriterioVO vlrl;

    /** The id. */
    private Long id;

    /** The padre id. */
    private Long padreId;

    /** The solo hijos. */
    private boolean soloHijos;
}
