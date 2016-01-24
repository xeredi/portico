package xeredi.argo.model.facturacion.vo;

import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaAgregadaVO.
 */
@Data
public final class ValoracionLineaAgregadaVO {

    /** The vlrl. */
    private ValoracionLineaVO vlrl;

    /** The vlrd list. */
    private List<ValoracionDetalleVO> vlrdList;
}
