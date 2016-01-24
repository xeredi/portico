package xeredi.argo.model.estadistica.vo;

import java.util.Map;

import lombok.Data;
import xeredi.argo.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaAgregadoVO.
 */
@Data
public final class EstadisticaAgregadoVO {

    /** The subp id. */
    private PuertoVO prto;

    /** The esdt map. */
    private Map<String, Object> esdtMap;
}
