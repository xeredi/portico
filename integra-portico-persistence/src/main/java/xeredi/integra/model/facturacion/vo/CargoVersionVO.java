package xeredi.integra.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoVersionVO.
 */
public final class CargoVersionVO {

    /** The id. */
    private Long id;

    /** The finicio. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The codigo normalizado. */
    private String codigoNormalizado;

    /** The principal. */
    private Boolean principal;

    /** The temporal. */
    private Boolean temporal;

    /** The tipo. */
    private CargoTipo tipo;

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
     *            the id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the finicio.
     *
     * @return the finicio
     */
    public Date getFini() {
        return fini;
    }

    /**
     * Sets the finicio.
     *
     * @param value
     *            the finicio
     */
    public void setFini(final Date value) {
        fini = value;
    }

    /**
     * Gets the ffin.
     *
     * @return the ffin
     */
    public Date getFfin() {
        return ffin;
    }

    /**
     * Sets the ffin.
     *
     * @param value
     *            the ffin
     */
    public void setFfin(final Date value) {
        ffin = value;
    }

    /**
     * Gets the codigo normalizado.
     *
     * @return the codigo normalizado
     */
    public String getCodigoNormalizado() {
        return codigoNormalizado;
    }

    /**
     * Sets the codigo normalizado.
     *
     * @param value
     *            the codigo normalizado
     */
    public void setCodigoNormalizado(final String value) {
        codigoNormalizado = value;
    }

    /**
     * Checks if is principal.
     *
     * @return true, if checks if is principal
     */
    public Boolean getPrincipal() {
        return principal;
    }

    /**
     * Sets the principal.
     *
     * @param value
     *            the principal
     */
    public void setPrincipal(final Boolean value) {
        principal = value;
    }

    /**
     * Checks if is temporal.
     *
     * @return true, if checks if is temporal
     */
    public Boolean getTemporal() {
        return temporal;
    }

    /**
     * Sets the temporal.
     *
     * @param value
     *            the temporal
     */
    public void setTemporal(final Boolean value) {
        temporal = value;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public CargoTipo getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param value
     *            the tipo
     */
    public void setTipo(final CargoTipo value) {
        tipo = value;
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
     *            the descripcion
     */
    public void setDescripcion(final String value) {
        descripcion = value;
    }

}
