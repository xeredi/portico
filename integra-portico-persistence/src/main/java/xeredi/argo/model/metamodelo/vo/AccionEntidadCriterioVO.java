package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionEntidadCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The enti id. */
    private Long entiId;

    /** The usro id. */
    private Long usroId;

    /** The grpo id. */
    private Long grpoId;
}
