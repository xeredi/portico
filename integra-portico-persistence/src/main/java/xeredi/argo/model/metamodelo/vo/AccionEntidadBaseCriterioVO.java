package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.comun.vo.ClassPrefix;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new accion entidad base criterio vo.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccionEntidadBaseCriterioVO extends BaseCriterioVO {
	/** The id. */
	private Long id;

	/** The prefix. */
	private ClassPrefix prefix;

	/** The codigo. */
	private AccionCodigo codigo;
}
