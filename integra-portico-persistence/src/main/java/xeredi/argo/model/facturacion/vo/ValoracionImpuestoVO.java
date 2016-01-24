package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionImpuestoVO.
 */
@Data
public final class ValoracionImpuestoVO {

    /** The vlrc id. */
    private Long vlrcId;

    /** The impuesto. */
    private ParametroVO impuesto;

    /** The porcentaje. */
    private Double porcentaje;

    /** The importe base. */
    private Double importeBase;

    /** The importe impuesto. */
    private Double importeImpuesto;
}
