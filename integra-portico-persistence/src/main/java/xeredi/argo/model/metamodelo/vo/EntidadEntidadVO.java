package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Modelable;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadVO.
 */
@Data
public final class EntidadEntidadVO implements Modelable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.enen;

    /** The enti padre id. */
    private Long entiPadreId;

    /** The enti hija id. */
    private EntidadVO entiHija;

    /** The orden. */
    private Integer orden;
}
