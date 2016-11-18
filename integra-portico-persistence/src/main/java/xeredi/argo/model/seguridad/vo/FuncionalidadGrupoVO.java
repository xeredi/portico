package xeredi.argo.model.seguridad.vo;

import java.io.Serializable;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Modelable;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new funcionalidad grupo VO.
 */
@Data
public final class FuncionalidadGrupoVO implements Modelable, Serializable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.fngr;

	/** The fncd id. */
	private Long fncdId;

	/** The grpo id. */
	private Long grpoId;
}
