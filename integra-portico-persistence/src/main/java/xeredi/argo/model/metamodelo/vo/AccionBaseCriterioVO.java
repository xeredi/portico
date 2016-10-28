package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new accion base criterio vo.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionBaseCriterioVO extends FuncionalidadCriterioVO {

	/** The prefix. */
	private AccionPrefix prefix;

	/** The codigo. */
	private AccionCodigo codigo;

}
