package xeredi.argo.model.proceso.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoMensajeVO.
 */
@Data
public final class ProcesoMensajeVO {

    /** The prbt id. */
    private Long prbtId;

    /** The nivel. */
    private MensajeNivel nivel;

    /** The codigo. */
    private MensajeCodigo codigo;

    /** The mensaje. */
    private String mensaje;
}
