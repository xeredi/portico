package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroTipoDatoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class EntidadTipoDatoCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The tppr id. */
    private Long entiId;

    /** The tpdt id. */
    private Long tpdtId;
}
