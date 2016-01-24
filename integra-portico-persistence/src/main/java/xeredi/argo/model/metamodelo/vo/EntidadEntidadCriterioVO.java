package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadCriterioVO.
 */
@Data
public final class EntidadEntidadCriterioVO extends BaseCriterioVO {

    /** The enti padre id. */
    private Long entiPadreId;

    /** The enti hija id. */
    private Long entiHijaId;
}
