package xeredi.argo.model.estadistica.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;
import xeredi.argo.model.item.vo.ItemDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.CampoDimensionVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new informe criterio vo.
 */

/**
 * Instantiates a new informe criterio vo.
 */
@Data
public final class InformeCriterioVO {

    /** The enti id. */
    private Long entiId;

    /** The dimension list. */
    private List<CampoDimensionVO> dimensionList = new ArrayList<>();

    /** The medida list. */
    private List<EntidadTipoDatoVO> medidaList = new ArrayList<>();

    /** The itdt map. */
    private Map<Long, ItemDatoCriterioVO> itdtMap;
}
