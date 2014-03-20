package xeredi.integra.model.vo.servicio;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioLupaCriterioVO.
 */
public final class ServicioLupaCriterioVO {

    /** The limit. */
    private Integer limit;

    /** The enti id. */
    private Long entiId;

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The subpuerto. */
    private String subpuerto;

    /** The anno. */
    private String anno;

    /** The numero. */
    private String numero;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the limit.
     * 
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     * 
     * @param value
     *            the new limit
     */
    public void setLimit(final Integer value) {
        limit = value;
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
     * Gets the subpuerto.
     * 
     * @return the subpuerto
     */
    public final String getSubpuerto() {
        return subpuerto;
    }

    /**
     * Sets the subpuerto.
     * 
     * @param value
     *            the new subpuerto
     */
    public final void setSubpuerto(String value) {
        this.subpuerto = value;
    }

    /**
     * Gets the anno.
     * 
     * @return the anno
     */
    public final String getAnno() {
        return anno;
    }

    /**
     * Sets the anno.
     * 
     * @param value
     *            the new anno
     */
    public final void setAnno(String value) {
        this.anno = value;
    }

    /**
     * Gets the numero.
     * 
     * @return the numero
     */
    public final String getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     * 
     * @param value
     *            the new numero
     */
    public final void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Gets the texto busqueda.
     * 
     * @return the texto busqueda
     */
    public final String getTextoBusqueda() {
        return textoBusqueda;
    }

    /**
     * Sets the texto busqueda.
     * 
     * @param value
     *            the new texto busqueda
     */
    public final void setTextoBusqueda(String value) {
        this.textoBusqueda = value;
    }

}
