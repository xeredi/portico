package xeredi.argo.model.facturacion.vo;

import java.util.Calendar;

import lombok.Data;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorVO.
 */
@Data
public final class FacturadorVO {

    /** The fcsr. */
    private Long fcsrId;

    /** The fecha facturacion. */
    private Calendar fecha;

    /** The tpsr. */
    private Long tpsrId;

    /** The prto. */
    private Long prtoId;

    /** The srvc. */
    private ServicioVO srvc;

    /** The vlrc. */
    private ValoracionVO vlrc;

    /** The pagador. */
    private ParametroVO pagador;

    /** The prbt id. */
    private Long prbtId;
}
