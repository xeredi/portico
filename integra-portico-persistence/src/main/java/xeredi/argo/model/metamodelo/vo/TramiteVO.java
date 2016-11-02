package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nable;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TramiteVO extends FuncionalidadVO implements I18nable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.trmt;

    /** The enti id. */
    private Long entiId;

    /** The estado orig. */
    private String estadoOrig;

    /** The estado dest. */
    private String estadoDest;

    /** The etiqueta. */
    private String etiqueta;

    /** The estado orig texto. */
    private String estadoOrigTexto;

    /** The estado dest texto. */
    private String estadoDestTexto;
}
