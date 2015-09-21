package xeredi.argo.model.proceso.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoArchivoVO.
 */
public final class ProcesoArchivoVO {

    /** The prbt id. */
    private Long prbtId;

    /** The sentido. */
    private Long archId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the prbt id.
     *
     * @return the prbt id
     */
    public Long getPrbtId() {
        return prbtId;
    }

    /**
     * Sets the prbt id.
     *
     * @param value
     *            the new prbt id
     */
    public void setPrbtId(final Long value) {
        prbtId = value;
    }

    /**
     * Gets the arch id.
     *
     * @return the arch id
     */
    public Long getArchId() {
        return archId;
    }

    /**
     * Sets the arch id.
     *
     * @param value
     *            the new arch id
     */
    public void setArchId(final Long value) {
        archId = value;
    }

}
