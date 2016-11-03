package xeredi.argo.model.proceso.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoParametroVO.
 */
@Data
public final class ProcesoParametroVO {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.prpm;

    /** The prbt id. */
    private Long prbtId;

    /** The nombre. */
    private String nombre;

    /** The valor. */
    private String valor;
}
