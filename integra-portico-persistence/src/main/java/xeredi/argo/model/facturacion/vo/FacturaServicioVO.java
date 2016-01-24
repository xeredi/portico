package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaServicioVO.
 */
@Data
public final class FacturaServicioVO {

    /** The id. */
    private Long id;

    /** The fctr id. */
    private Long fctrId;

    /** The srvc. */
    private ServicioVO srvc;

    /** The aspc. */
    private AspectoVO aspc;

    /** The cod exencion. */
    private String codExencion;

    /** The fref. */
    private Date fref;

    /** The fini. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The importe. */
    private Double importe;
}
