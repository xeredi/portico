package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AspectoCargoCriterioVO extends BaseCriterioVO {

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The id. */
    private Long id;

    /** The aspc id. */
    private Long aspcId;
}
