package xeredi.argo.model.seguridad.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Identifiable;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioVO.
 */

/**
 * {@inheritDoc}
 */
@Data
public final class UsuarioVO implements Identifiable, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1393605997535392428L;

	/** The prefix. */
	private final transient ClassPrefix prefix = ClassPrefix.usro;

	/** The id. */
	private Long id;

	/** The login. */
	private String login;

	/** The contrasenia. */
	private String contrasenia;

	/** The email. */
	private String email;

	/** The nombre. */
	private String nombre;

	/** The sprt. */
	private SuperpuertoVO sprt;

	/** The prto. */
	private PuertoVO prto;

	/** The orga. */
	private ParametroVO orga;

	/** The grpo ids. */
	private Set<Long> grpoIds;

	/**
	 * Instantiates a new usuario vo.
	 */
	public UsuarioVO() {
		super();

		grpoIds = new HashSet<>();
	}
}
