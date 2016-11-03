package xeredi.argo.model.seguridad.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioGrupoVO.
 */
@Data
public final class UsuarioGrupoVO {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.usgr;

    /** The usro id. */
    private final Long usroId;

    /** The grpo id. */
    private final Long grpoId;

    /**
     * Instantiates a new usuario grupo vo.
     *
     * @param ausroId
     *            the ausro id
     * @param agrpoId
     *            the agrpo id
     */
    public UsuarioGrupoVO(final Long ausroId, final Long agrpoId) {
        super();
        usroId = ausroId;
        grpoId = agrpoId;
    }
}
