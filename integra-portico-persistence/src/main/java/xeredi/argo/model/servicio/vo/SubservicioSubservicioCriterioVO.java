package xeredi.argo.model.servicio.vo;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * SubservicioSubservicioCriterioVO.
 */
@Data
public class SubservicioSubservicioCriterioVO extends BaseCriterioVO {

    /** The srvc id. */
    private Long srvcId;

    /** The ssrv padre ids. */
    private final Set<Long> ssrvPadreIds = new HashSet<>();

    /** The ssrv hijo ids. */
    private final Set<Long> ssrvHijoIds = new HashSet<>();
}
