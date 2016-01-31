package xeredi.argo.model.servicio.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ServicioSecuenciaCriterioVO extends BaseCriterioVO {

    /** The prto id. */
    private Long prtoId;

    /** The tpsr id. */
    private Long tpsrId;

    /** The anno. */
    private Integer anno;
}
