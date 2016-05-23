package xeredi.argo.model.item.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemCriterioVO.
 */

/**
 * @author xeredi
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class ItemCriterioVO extends BaseCriterioVO {
    /** The solo gridables. */
    private boolean soloDatosGrid;

    /** The etiqueta. */
    private String etiqueta;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The enti id. */
    private Long entiId;

    /** The enti ids. */
    private Set<Long> entiIds;

    /** The itdt map. */
    private Map<Long, ItemDatoCriterioVO> itdtMap;

    /**
     * Instantiates a new item criterio vo.
     */
    public ItemCriterioVO() {
        super();

        itdtMap = new HashMap<>();
    }
}
