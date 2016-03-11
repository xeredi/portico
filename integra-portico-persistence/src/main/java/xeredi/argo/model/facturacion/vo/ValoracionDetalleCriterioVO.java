package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleCriterioVO.
 */

/**
 * Instantiates a new valoracion detalle criterio vo.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ValoracionDetalleCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The padre id. */
    private Long padreId;

    /** The vlrl id. */
    private Long vlrlId;

    /** The vlrc id. */
    private Long vlrcId;

    /** The fctr id. */
    private Long fctrId;

    /** The solo hijos. */
    private boolean soloHijos;
}
