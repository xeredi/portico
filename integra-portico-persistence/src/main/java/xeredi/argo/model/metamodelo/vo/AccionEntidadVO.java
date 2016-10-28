package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionEntidadVO extends FuncionalidadVO {

    /** The aebs. */
    private AccionEntidadBaseVO aebs;

    /** The enti id. */
    private Long entiId;
}
