package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TramiteVO extends FuncionalidadVO {
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
