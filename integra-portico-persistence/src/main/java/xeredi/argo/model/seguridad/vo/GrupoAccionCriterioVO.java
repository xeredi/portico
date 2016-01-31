package xeredi.argo.model.seguridad.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class GrupoAccionCriterioVO extends BaseCriterioVO {

    /** The grpo id. */
    private Long grpoId;

    /** The accn id. */
    private Long accnId;
}
