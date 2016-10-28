package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.ClassPrefix;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new accion entidad criterio VO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionEntidadCriterioVO extends FuncionalidadCriterioVO {

	/** The prefix. */
	private ClassPrefix prefix;

	/** The codigo. */
	private AccionCodigo codigo;

    /** The enti id. */
    private Long entiId;
}
