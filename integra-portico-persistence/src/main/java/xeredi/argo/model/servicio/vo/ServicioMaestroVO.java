package xeredi.argo.model.servicio.vo;

import java.util.Date;
import java.util.Map;

import lombok.Data;
import xeredi.argo.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioMaestroVO.
 */
@Data
public final class ServicioMaestroVO {

    /** The subp id. */
    private PuertoVO prto;

    /** The fini. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The esdt map. */
    private Map<String, Object> itdtMap;
}
