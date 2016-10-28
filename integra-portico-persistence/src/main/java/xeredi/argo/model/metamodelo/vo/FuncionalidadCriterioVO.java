package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new funcionalidad criterio vo.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FuncionalidadCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The grpo id. */
    private Long grpoId;

    /** The usro id. */
    private Long usroId;
}
