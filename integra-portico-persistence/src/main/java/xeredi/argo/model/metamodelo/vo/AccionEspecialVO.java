package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.I18nable;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new accion especial VO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionEspecialVO extends FuncionalidadVO implements I18nable {
	/** The codigo. */
	private String path;

    /** The enti. */
    private Long entiId;

    /** The orden. */
    private Integer orden;

    /** The etiqueta. */
    private String etiqueta;
}
