package xeredi.argo.model.seguridad.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioGrupoVO.
 */
public final class UsuarioGrupoVO {

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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the usro id.
     *
     * @return the usro id
     */
    public Long getUsroId() {
        return usroId;
    }

    /**
     * Gets the grpo id.
     *
     * @return the grpo id
     */
    public Long getGrpoId() {
        return grpoId;
    }

}
