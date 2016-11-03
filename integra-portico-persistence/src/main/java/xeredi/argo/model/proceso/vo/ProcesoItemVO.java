package xeredi.argo.model.proceso.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Modelable;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoItemVO.
 */
@Data
public final class ProcesoItemVO implements Modelable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.prit;

    /** The prbt id. */
    private Long prbtId;

    /** The sentido. */
    private ItemSentido sentido;

    /** The item id. */
    private Long itemId;

    /** The tipo. */
    private ItemTipo tipo;

    /** The enti id. */
    private Long entiId;

    /** The etiqueta. */
    private String etiqueta;
}
