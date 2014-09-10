package xeredi.integra.model.facturacion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoVO.
 */
public final class CargoVO {

    /** The ig. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The codigo normalizado. */
    private String codigoNormalizado;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The principal. */
    private Boolean principal;

    /** The temporal. */
    private Boolean temporal;

    /** The tipo. */
    private CargoTipo tipo;

    /** The descripcion. */
    private String descripcion;

    /** The crgv. */
    private CargoVersionVO crgv;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        final StringBuffer buffer = new StringBuffer();

        buffer.append(codigo);

        if (descripcion != null) {
            buffer.append(" - ").append(descripcion);
        }

        return buffer.toString();
    }

    /**
     * Gets the ig.
     *
     * @return the ig
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ig.
     *
     * @param value
     *            the ig
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
     *            the codigo
     */
    public void setCodigo(final String value) {
        codigo = value;
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
     * Gets the tpsr.
     *
     * @return the tpsr
     */
    public TipoServicioVO getTpsr() {
        return tpsr;
    }

    /**
     * Sets the tpsr.
     *
     * @param value
     *            the tpsr
     */
    public void setTpsr(final TipoServicioVO value) {
        tpsr = value;
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

    /**
     * Gets the crgv.
     *
     * @return the crgv
     */
    public CargoVersionVO getCrgv() {
        return crgv;
    }

    /**
     * Sets the crgv.
     *
     * @param value
     *            the crgv
     */
    public void setCrgv(final CargoVersionVO value) {
        crgv = value;
    }

}
