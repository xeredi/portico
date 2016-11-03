package xeredi.argo.model.proceso.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Modelable;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoMensajeVO.
 */
@Data
public final class ProcesoMensajeVO implements Modelable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.prmn;

    /** The prbt id. */
    private Long prbtId;

    /** The nivel. */
    private MensajeNivel nivel;

    /** The codigo. */
    private MensajeCodigo codigo;

    /** The mensaje. */
    private String mensaje;
}
