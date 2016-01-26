package xeredi.argo.model.metamodelo.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroDetailVO.
 */

/**
 * Instantiates a new tipo parametro detail vo.
 */
@Data
public final class TipoParametroDetailVO extends AbstractEntidadDetailVO {

    /** The tppr. */
    private TipoParametroVO enti;

    /** The subenti list. */
    private List<TipoSubparametroVO> subentiList = new ArrayList<>();
}
