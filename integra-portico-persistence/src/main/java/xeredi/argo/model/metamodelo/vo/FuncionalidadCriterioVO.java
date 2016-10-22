package xeredi.argo.model.metamodelo.vo;

import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new funcionalidad criterio vo.
 */
@Data
/**
 * Hash code.
 *
 * @return the int
 */
@EqualsAndHashCode(callSuper = true)
public class FuncionalidadCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The prefix. */
    private AccionPrefix prefix;

    /** The path. */
    private String path;
}
