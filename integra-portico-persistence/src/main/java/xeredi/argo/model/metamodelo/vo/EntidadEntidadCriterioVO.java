package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class EntidadEntidadCriterioVO extends BaseCriterioVO {

    /** The enti padre id. */
    private Long entiPadreId;

    /** The enti hija id. */
    private Long entiHijaId;
}
