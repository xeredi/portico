package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.ClassPrefix;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new accion base criterio vo.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionBaseCriterioVO extends FuncionalidadCriterioVO {

	/** The prefix. */
	private ClassPrefix prefix;

	/** The codigo. */
	private AccionCodigo codigo;

}
