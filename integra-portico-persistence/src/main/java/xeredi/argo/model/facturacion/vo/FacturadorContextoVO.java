package xeredi.argo.model.facturacion.vo;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorContextoVO.
 */
public final class FacturadorContextoVO {

    /** The prbt. */
    private ProcesoVO prbt;

    /** The aspc. */
    private AspectoVO aspc;

    /** The fcsr. */
    private FacturaSerieVO fcsr;

    /** The fecha facturacion. */
    private Date fechaFacturacion;

    /** The vlcr ids. */
    private Set<Long> vlrcIds;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the prbt.
     *
     * @return the prbt
     */
    public ProcesoVO getPrbt() {
        return prbt;
    }

    /**
     * Sets the prbt.
     *
     * @param value
     *            the prbt
     */
    public void setPrbt(ProcesoVO value) {
        this.prbt = value;
    }

    /**
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
    }

    /**
     * Sets the aspc.
     *
     * @param value
     *            the aspc
     */
    public void setAspc(AspectoVO value) {
        this.aspc = value;
    }

    /**
     * Gets the fcsr.
     *
     * @return the fcsr
     */
    public FacturaSerieVO getFcsr() {
        return fcsr;
    }

    /**
     * Sets the fcsr.
     *
     * @param value
     *            the fcsr
     */
    public void setFcsr(FacturaSerieVO value) {
        this.fcsr = value;
    }

    /**
     * Gets the fecha facturacion.
     *
     * @return the fecha facturacion
     */
    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    /**
     * Sets the fecha facturacion.
     *
     * @param value
     *            the fecha facturacion
     */
    public void setFechaFacturacion(Date value) {
        this.fechaFacturacion = value;
    }

    /**
     * Gets the vlcr ids.
     *
     * @return the vlcr ids
     */
    public Set<Long> getVlrcIds() {
        return vlrcIds;
    }

    /**
     * Sets the vlcr ids.
     *
     * @param value
     *            the vlcr ids
     */
    public void setVlrcIds(Set<Long> value) {
        this.vlrcIds = value;
    }

}
