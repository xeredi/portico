package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new accion base vo.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionBaseVO extends FuncionalidadVO {

	/** The prefix. */
	private AccionPrefix prefix;

	/** The codigo. */
	private AccionCodigo codigo;

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return new StringBuilder().append(prefix).append("-").append(codigo).toString();
	}
}
