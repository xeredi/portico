package xeredi.argo.model.metamodelo.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new accion entidad base VO.
 */
@Data
public class AccionEntidadBaseVO {

	/** The id. */
	private Long id;

	/** The prefix. */
	private AccionPrefix prefix;

	/** The codigo. */
	private AccionCodigo codigo;

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public final String getPath() {
		return new StringBuilder().append(prefix).append("-").append(codigo).toString();
	}
}
