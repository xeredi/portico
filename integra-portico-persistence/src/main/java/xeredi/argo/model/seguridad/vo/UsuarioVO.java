package xeredi.argo.model.seguridad.vo;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioVO.
 */
@Data
public final class UsuarioVO {

    /** The id. */
    private Long id;

    /** The login. */
    private String login;

    /** The contrasenia. */
    private String contrasenia;

    /** The nombre. */
    private String nombre;

    /** The sprt. */
    private SuperpuertoVO sprt;

    /** The prto. */
    private PuertoVO prto;

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
