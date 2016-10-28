package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new accion entidad criterio VO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionEntidadCriterioVO extends FuncionalidadCriterioVO {

	/** The prefix. */
	private AccionPrefix prefix;

	/** The codigo. */
	private AccionCodigo codigo;

    /** The enti id. */
    private Long entiId;
}
