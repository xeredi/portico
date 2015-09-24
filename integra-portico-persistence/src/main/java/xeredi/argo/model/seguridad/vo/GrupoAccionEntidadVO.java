package xeredi.argo.model.seguridad.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionEntidadVO.
 */
public final class GrupoAccionEntidadVO {

    /** The grpo id. */
    private Long grpoId;

    /** The acen id. */
    private Long acenId;

    /**
     * Instantiates a new grupo accion entidad vo.
     */
    public GrupoAccionEntidadVO() {
        super();
    }

    /**
     * Instantiates a new grupo accion entidad vo.
     *
     * @param agrpoId the agrpo id
     * @param aacenId the aacen id
     */
    public GrupoAccionEntidadVO(final Long agrpoId, final Long aacenId) {
        super();
        grpoId = agrpoId;
        acenId = aacenId;
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
     * @param value the new grpo id
     */
    public void setGrpoId(Long value) {
        this.grpoId = value;
    }

    /**
     * Gets the acen id.
     *
     * @return the acen id
     */
    public Long getAcenId() {
        return acenId;
    }

    /**
     * Sets the acen id.
     *
     * @param value the new acen id
     */
    public void setAcenId(Long value) {
        this.acenId = value;
    }
}
