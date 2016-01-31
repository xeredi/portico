package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoSubservicioCriterioVO extends EntidadCriterioVO {
    /** The tpsr id. */
    private Long tpsrId;

    /** The facturable. */
    private Boolean facturable;
}
