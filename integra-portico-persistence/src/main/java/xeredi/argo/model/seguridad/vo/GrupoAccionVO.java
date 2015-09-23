package xeredi.argo.model.seguridad.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionVO.
 */
public final class GrupoAccionVO {

    /** The grpo id. */
    private Long grpoId;

    /** The accn id. */
    private Long accnId;

    /**
     * Instantiates a new grupo accion vo.
     */
    public GrupoAccionVO() {
        super();
    }

    /**
     * Instantiates a new grupo accion vo.
     *
     * @param agrpoId
     *            the agrpo id
     * @param aaccnId
     *            the aaccn id
     */
    public GrupoAccionVO(final Long agrpoId, final Long aaccnId) {
        super();
        grpoId = agrpoId;
        accnId = aaccnId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the grpo id.
     *
     * @return the grpo id
     */
    public Long getGrpoId() {
        return grpoId;
    }

    /**
     * Sets the grpo id.
     *
     * @param value
     *            the new grpo id
     */
    public void setGrpoId(Long value) {
        this.grpoId = value;
    }

    /**
     * Gets the accn id.
     *
     * @return the accn id
     */
    public Long getAccnId() {
        return accnId;
    }

    /**
     * Sets the accn id.
     *
     * @param value
     *            the new accn id
     */
    public void setAccnId(Long value) {
        this.accnId = value;
    }
}
