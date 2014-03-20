package xeredi.integra.model.vo.configuracion;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class IdiomaVO.
 */
public final class IdiomaVO {

    /** The id. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The descripcion. */
    private String descripcion;

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
     * Gets the codigo.
     * 
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     * 
     * @param value
     *            the new codigo
     */
    public void setCodigo(final String value) {
        codigo = value;
    }

    /**
     * Gets the descripcion.
     * 
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the descripcion.
     * 
     * @param value
     *            the new descripcion
     */
    public void setDescripcion(final String value) {
        descripcion = value;
    }

}
