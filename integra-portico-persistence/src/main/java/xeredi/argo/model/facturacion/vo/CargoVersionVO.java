package xeredi.argo.model.facturacion.vo;

import xeredi.argo.model.comun.vo.VersionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoVersionVO.
 */
public final class CargoVersionVO extends VersionVO {
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
