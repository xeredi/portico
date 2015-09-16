package xeredi.integra.model.facturacion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionCargoVO.
 */
public final class ValoracionCargoVO {

    /** The vlrc id. */
    private Long vlrcId;

    /** The crgo. */
    private CargoVO crgo;

    /** The importe. */
    private Double importe;

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
     *            the vlrc id
     */
    public void setVlrcId(final Long value) {
        vlrcId = value;
    }

    /**
     * Gets the crgo.
     *
     * @return the crgo
     */
    public CargoVO getCrgo() {
        return crgo;
    }

    /**
     * Sets the crgo.
     *
     * @param value
     *            the crgo
     */
    public void setCrgo(final CargoVO value) {
        crgo = value;
    }

    /**
     * Gets the importe.
     *
     * @return the importe
     */
    public Double getImporte() {
        return importe;
    }

    /**
     * Sets the importe.
     *
     * @param value
     *            the new importe
     */
    public void setImporte(final Double value) {
        importe = value;
    }

}
