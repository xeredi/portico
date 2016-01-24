package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaCriterioVO.
 */
@Data
public final class ValoracionLineaCriterioVO extends BaseCriterioVO {

    /** The vlrc. */
    private ValoracionCriterioVO vlrc;

    /** The id. */
    private Long id;

    /** The padre id. */
    private Long padreId;

    /** The solo hijos. */
    private boolean soloHijos;
}
