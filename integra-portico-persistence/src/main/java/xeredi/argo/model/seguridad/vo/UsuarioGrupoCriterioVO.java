package xeredi.argo.model.seguridad.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioGrupoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class UsuarioGrupoCriterioVO extends BaseCriterioVO {

    /** The usro id. */
    private Long usroId;

    /** The grpo id. */
    private Long grpoId;
}
