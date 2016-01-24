package xeredi.argo.model.facturacion.vo;

import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaAgregadaVO.
 */
@Data
public final class FacturaAgregadaVO {

    /** The fctr. */
    private FacturaVO fctr;

    /** The fcts list. */
    private List<FacturaServicioVO> fctsList;
}
