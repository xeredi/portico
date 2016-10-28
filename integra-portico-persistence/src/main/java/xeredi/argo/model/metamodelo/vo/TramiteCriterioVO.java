package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TramiteCriterioVO extends FuncionalidadCriterioVO {
    /** The enti id. */
    private Long entiId;

    /** The estado orig. */
    private String estadoOrig;
}
