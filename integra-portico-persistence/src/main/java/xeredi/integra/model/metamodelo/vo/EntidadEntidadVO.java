package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadVO.
 */
public final class EntidadEntidadVO {

    /** The enti padre id. */
    private Long entiPadreId;

    /** The enti hija id. */
    private EntidadVO entiHija;

    /** The orden. */
    private Integer orden;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the enti padre id.
     *
     * @return the enti padre id
     */
    public Long getEntiPadreId() {
        return entiPadreId;
    }

    /**
     * Sets the enti padre id.
     *
     * @param value
     *            the new enti padre id
     */
    public void setEntiPadreId(final Long value) {
        entiPadreId = value;
    }

    /**
     * Gets the enti hija id.
     *
     * @return the enti hija id
     */
    public EntidadVO getEntiHija() {
        return entiHija;
    }

    /**
     * Sets the enti hija id.
     *
     * @param value
     *            the new enti hija id
     */
    public void setEntiHija(final EntidadVO value) {
        entiHija = value;
    }

    /**
     * Gets the orden.
     *
     * @return the orden
     */
    public Integer getOrden() {
        return orden;
    }

    /**
     * Sets the orden.
     *
     * @param value
     *            the new orden
     */
    public void setOrden(final Integer value) {
        orden = value;
    }

}
