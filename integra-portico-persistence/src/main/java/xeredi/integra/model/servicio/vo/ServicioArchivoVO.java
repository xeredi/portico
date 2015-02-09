package xeredi.integra.model.servicio.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioArchivoVO.
 */
public final class ServicioArchivoVO {

    /** The prbt id. */
    private Long srvcId;

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
     * Gets the srvc id.
     *
     * @return the srvc id
     */
    public Long getSrvcId() {
        return srvcId;
    }

    /**
     * Sets the srvc id.
     *
     * @param value
     *            the new srvc id
     */
    public void setSrvcId(final Long value) {
        srvcId = value;
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
