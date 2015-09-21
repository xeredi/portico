package xeredi.argo.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionVO.
 */
public final class EntidadAccionVO {

    /** The id. */
    private Long id;

    /** The enti id. */
    private Long entiId;

    /** The path. */
    private String path;

    /** The etiqueta. */
    private String etiqueta;

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
     * Gets the path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path.
     *
     * @param value
     *            the new path
     */
    public void setPath(final String value) {
        path = value;
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

}
