package xeredi.argo.model.facturacion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaCargoVO.
 */
public final class FacturaCargoVO {

    /** The fctr id. */
    private Long fctrId;

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
     * Gets the fctr id.
     *
     * @return the fctr id
     */
    public Long getFctrId() {
        return fctrId;
    }

    /**
     * Sets the fctr id.
     *
     * @param value
     *            the fctr id
     */
    public void setFctrId(final Long value) {
        fctrId = value;
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
