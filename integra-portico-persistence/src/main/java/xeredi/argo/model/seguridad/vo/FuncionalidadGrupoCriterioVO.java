package xeredi.argo.model.seguridad.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new funcionalidad grupo criterio VO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class FuncionalidadGrupoCriterioVO extends BaseCriterioVO {

	/** The fncd id. */
	private Long fncdId;

	/** The grpo id. */
	private Long grpoId;
}
