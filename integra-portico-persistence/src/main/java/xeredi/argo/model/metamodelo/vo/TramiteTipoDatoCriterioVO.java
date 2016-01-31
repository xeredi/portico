package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TramiteTipoDatoCriterioVO extends BaseCriterioVO {

    /** The trmt id. */
    private Long trmtId;

    /** The tpdt id. */
    private Long tpdtId;
}
