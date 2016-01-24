package xeredi.argo.model.metamodelo.vo;

import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaCriterioVO.
 */
@Data
public final class CodigoReferenciaCriterioVO extends BaseCriterioVO {
    /** The id. */
    private Long id;

    /** The tpdt id. */
    private Long tpdtId;

    /** The tpdt ids. */
    private Set<Long> tpdtIds;

    /** The valor. */
    private String valor;
}
