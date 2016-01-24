package xeredi.argo.model.facturacion.vo;

import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionAgregadaVO.
 */
@Data
public final class ValoracionAgregadaVO {

    /** The vlrc. */
    private ValoracionVO vlrc;

    /** The vlrl list. */
    private List<ValoracionLineaAgregadaVO> vlrlList;
}
