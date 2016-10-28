package xeredi.argo.model.seguridad.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class GrupoCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The usro id. */
    private Long usroId;

    /** The accn id. */
    private Long fncdId;

    /** The nombre. */
    private String nombre;
}
