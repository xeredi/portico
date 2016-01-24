package xeredi.argo.model.item.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteCriterioVO.
 */
@Data
public final class ItemTramiteCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The item id. */
    private Long itemId;

    /** The fecha vigencia. */
    private Date fechaVigencia;
}
