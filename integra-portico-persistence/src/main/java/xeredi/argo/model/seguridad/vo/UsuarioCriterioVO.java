package xeredi.argo.model.seguridad.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Modelable;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class UsuarioCriterioVO extends BaseCriterioVO implements Modelable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.usro;

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
