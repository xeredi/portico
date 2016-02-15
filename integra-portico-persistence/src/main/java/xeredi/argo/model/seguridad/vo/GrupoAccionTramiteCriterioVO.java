package xeredi.argo.model.seguridad.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

/**
 * The Class GrupoAccionTramiteCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class GrupoAccionTramiteCriterioVO extends BaseCriterioVO {

    /** The grpo id. */
    private Long grpoId;

    /** The actr id. */
    private Long actrId;
}
