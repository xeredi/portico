package xeredi.argo.model.estadistica.vo;

import java.util.Map;

import lombok.Data;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.item.vo.ItemDatoVO;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new informe item vo.
 */
@Data
public final class InformeItemVO {

    /** The prto. */
    private PuertoVO prto;

    /** The dimension itdt map. */
    private Map<Long, ItemDatoVO> dimensionItdtMap;

    /** The medida itdt map. */
    private Map<Long, ItemDatoVO> medidaItdtMap;
}
