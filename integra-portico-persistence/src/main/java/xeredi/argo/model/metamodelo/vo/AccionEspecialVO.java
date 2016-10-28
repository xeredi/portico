package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new accion especial VO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionEspecialVO extends FuncionalidadVO {

	/** The prefix. */
	private AccionPrefix prefix;

	/** The codigo. */
	private String path;

    /** The enti. */
    private Long entiId;

    /** The orden. */
    private Integer orden;

    /** The etiqueta. */
    private String etiqueta;
}
