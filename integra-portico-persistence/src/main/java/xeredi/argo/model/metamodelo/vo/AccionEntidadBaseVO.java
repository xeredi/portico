package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Identifiable;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new accion entidad base VO.
 */
@Data
public class AccionEntidadBaseVO implements Identifiable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.aebs;

	/** The id. */
	private Long id;

	/** The codigo. */
	private AccionCodigo codigo;
}
