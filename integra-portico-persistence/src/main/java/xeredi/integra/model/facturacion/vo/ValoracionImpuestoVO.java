package xeredi.integra.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionImpuestoVO.
 */
public final class ValoracionImpuestoVO {

    /** The vlrc id. */
    private Long vlrcId;

    /** The impuesto. */
    private ParametroVO impuesto;

    /** The porcentaje. */
    private Double porcentaje;

    /** The importe base. */
    private Double importeBase;

    /** The importe impuesto. */
    private Double importeImpuesto;

    /** The fref. */
    private Date fref;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the vlrc id.
     *
     * @return the vlrc id
     */
    public Long getVlrcId() {
        return vlrcId;
    }

    /**
     * Sets the vlrc id.
     *
     * @param value
     *            the new vlrc id
     */
    public void setVlrcId(final Long value) {
        vlrcId = value;
    }

    /**
     * Gets the impuesto.
     *
     * @return the impuesto
     */
    public ParametroVO getImpuesto() {
        return impuesto;
    }

    /**
     * Sets the impuesto.
     *
     * @param value
     *            the new impuesto
     */
    public void setImpuesto(final ParametroVO value) {
        impuesto = value;
    }

    /**
     * Gets the importe base.
     *
     * @return the importe base
     */
    public Double getImporteBase() {
        return importeBase;
    }

    /**
     * Sets the importe base.
     *
     * @param value
     *            the new importe base
     */
    public void setImporteBase(final Double value) {
        importeBase = value;
    }

    /**
     * Gets the importe impuesto.
     *
     * @return the importe impuesto
     */
    public Double getImporteImpuesto() {
        return importeImpuesto;
    }

    /**
     * Sets the importe impuesto.
     *
     * @param value
     *            the new importe impuesto
     */
    public void setImporteImpuesto(final Double value) {
        importeImpuesto = value;
    }

    /**
     * Gets the porcentaje.
     *
     * @return the porcentaje
     */
    public Double getPorcentaje() {
        return porcentaje;
    }

    /**
     * Sets the porcentaje.
     *
     * @param value
     *            the new porcentaje
     */
    public void setPorcentaje(final Double value) {
        porcentaje = value;
    }

    /**
     * Gets the fref.
     *
     * @return the fref
     */
    public Date getFref() {
        return fref;
    }

    /**
     * Sets the fref.
     *
     * @param value
     *            the new fref
     */
    public void setFref(final Date value) {
        fref = value;
    }

}
