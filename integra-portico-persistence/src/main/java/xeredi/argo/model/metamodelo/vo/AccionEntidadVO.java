package xeredi.argo.model.metamodelo.vo;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.seguridad.vo.AccionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadVO.
 */
@Data
public final class AccionEntidadVO {
    /** The id. */
    private Long id;

    /** The accn id. */
    private AccionVO accn;

    /** The enti id. */
    private Long entiId;

    /** The grpo ids. */
    private Set<Long> grpoIds = new HashSet<>();
}
