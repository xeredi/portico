package xeredi.integra.model.configuracion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class EntornoVO.
 */
public final class EntornoVO {

    /** The id. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The nombre. */
    private String nombre;

    /** The cnid. */
    private IdiomaVO cnid;

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
    public void setId(Long value) {
        this.id = value;
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
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Gets the nombre.
     * 
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     * 
     * @param value
     *            the new nombre
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the cnid.
     * 
     * @return the cnid
     */
    public IdiomaVO getCnid() {
        return cnid;
    }

    /**
     * Sets the cnid.
     * 
     * @param value
     *            the new cnid
     */
    public void setCnid(IdiomaVO value) {
        this.cnid = value;
    }

}
