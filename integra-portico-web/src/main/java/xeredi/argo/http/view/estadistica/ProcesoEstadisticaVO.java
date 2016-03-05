package xeredi.argo.http.view.estadistica;

import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new proceso estadistica vo.
 */
@Data
public final class ProcesoEstadisticaVO {
    /** The sobreescribir. */
    private Boolean sobreescribir;

    /** The archId. */
    private Long archId;

    /** The pepr. */
    private PeriodoProcesoVO pepr;
}
