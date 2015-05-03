package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteVO.
 */
public final class TramiteVO {

    /** The id. */
    private Long id;

    /** The enti id. */
    private Long entiId;

    /** The estado orig. */
    private String estadoOrig;

    /** The estado dest. */
    private String estadoDest;

    /** The etiqueta. */
    private String etiqueta;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the enti id.
     *
     * @return the enti id
     */
    public Long getEntiId() {
        return entiId;
    }

    /**
     * Sets the enti id.
     *
     * @param value
     *            the new enti id
     */
    public void setEntiId(final Long value) {
        entiId = value;
    }

    /**
     * Gets the estado orig.
     *
     * @return the estado orig
     */
    public String getEstadoOrig() {
        return estadoOrig;
    }

    /**
     * Sets the estado orig.
     *
     * @param value
     *            the new estado orig
     */
    public void setEstadoOrig(final String value) {
        estadoOrig = value;
    }

    /**
     * Gets the estado dest.
     *
     * @return the estado dest
     */
    public String getEstadoDest() {
        return estadoDest;
    }

    /**
     * Sets the estado dest.
     *
     * @param value
     *            the new estado dest
     */
    public void setEstadoDest(final String value) {
        estadoDest = value;
    }

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Sets the etiqueta.
     *
     * @param value
     *            the new etiqueta
     */
    public void setEtiqueta(final String value) {
        etiqueta = value;
    }
}
