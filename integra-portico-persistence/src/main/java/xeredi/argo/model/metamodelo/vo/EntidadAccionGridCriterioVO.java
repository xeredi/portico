package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionGridCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class EntidadAccionGridCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The enti id. */
    private Long entiId;

    /** The path. */
    private String path;
}
