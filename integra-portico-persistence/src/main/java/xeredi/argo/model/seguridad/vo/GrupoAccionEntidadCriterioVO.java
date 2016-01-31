package xeredi.argo.model.seguridad.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionEntidadCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class GrupoAccionEntidadCriterioVO extends BaseCriterioVO {

    /** The grpo id. */
    private Long grpoId;

    /** The acen id. */
    private Long acenId;
}
