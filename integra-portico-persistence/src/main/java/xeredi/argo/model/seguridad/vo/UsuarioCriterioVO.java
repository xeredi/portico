package xeredi.argo.model.seguridad.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class UsuarioCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The login. */
    private String login;

    /** The prto id. */
    private Long prtoId;

    /** The sprt id. */
    private Long sprtId;

    /** The grpo id. */
    private Long grpoId;
}
