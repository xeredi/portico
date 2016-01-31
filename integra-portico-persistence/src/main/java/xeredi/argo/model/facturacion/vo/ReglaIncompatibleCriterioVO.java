package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ReglaIncompatibleCriterioVO extends BaseCriterioVO {

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The id. */
    private Long id;

    /** The rgiv id. */
    private Long rgivId;

    /** The rgla1 id. */
    private Long rgla1Id;
}
