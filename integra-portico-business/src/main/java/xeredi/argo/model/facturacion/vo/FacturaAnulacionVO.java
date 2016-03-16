package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new factura anulacion vo.
 */
@Data
public final class FacturaAnulacionVO {

    /** The fctr id. */
    private Long fctrId;

    /** The fcsr id. */
    private Long fcsrId;

    /** The fecha. */
    private Date fecha;

    /** The observaciones. */
    private String observaciones;

    /** Identificador factura anulacion. */
    private Long fctrAnulacionId;
}
