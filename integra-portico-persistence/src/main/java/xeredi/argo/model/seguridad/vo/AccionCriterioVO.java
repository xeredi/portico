package xeredi.argo.model.seguridad.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionCriterioVO.
 */
@Data
public final class AccionCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The prefix. */
    private AccionPrefix prefix;

    /** The codigo. */
    private String codigo;

    /** The enti id. */
    private Long entiId;

    /** The grpo id. */
    private Long grpoId;

    /** The usro id. */
    private Long usroId;
}
