package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaImpuestoVO.
 */
@Data
public final class FacturaImpuestoVO {

    /** The fctr id. */
    private Long fctrId;

    /** The impuesto. */
    private ParametroVO impuesto;

    /** The porcentaje. */
    private Double porcentaje;

    /** The importe base. */
    private Double importeBase;

    /** The importe impuesto. */
    private Double importeImpuesto;
}
