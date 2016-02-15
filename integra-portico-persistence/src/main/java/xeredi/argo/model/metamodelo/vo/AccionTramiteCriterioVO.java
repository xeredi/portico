package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

/**
 * Criterio de búsqueda de acciones asociadas a trámites.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionTramiteCriterioVO extends BaseCriterioVO {
    /** Identificador de acción de trámite. */
    private Long id;

    /** Identificador de trámite. */
    private Long trmtId;

    /** Identificador de usuario. */
    private Long usroId;

    /** Identificador de grupo de usuarios. */
    private Long grpoId;
}
