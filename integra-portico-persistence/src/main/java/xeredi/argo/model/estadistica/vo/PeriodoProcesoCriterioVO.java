package xeredi.argo.model.estadistica.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class PeriodoProcesoCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The autp id. */
    private Long sprtId;

    /** The prto id. */
    private Long prtoId;

    /** The anio. */
    private Integer anio;

    /** The mes. */
    private Integer mes;

    /** The trimestre. */
    private Integer trimestre;
}
