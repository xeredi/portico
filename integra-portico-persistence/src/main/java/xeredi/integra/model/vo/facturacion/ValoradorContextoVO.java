package xeredi.integra.model.vo.facturacion;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.vo.metamodelo.TipoServicioVO;
import xeredi.integra.model.vo.proceso.ProcesoVO;
import xeredi.integra.model.vo.servicio.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionContextoVO.
 */
public final class ValoradorContextoVO {

    /** The prbt. */
    private ProcesoVO prbt;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The srvc. */
    private ServicioVO srvc;

    /** The crgo. */
    private CargoVO crgo;

    /** The fecha liquidacion. */
    private Date fliquidacion;

    /** The fecha inicio. */
    private Date finicio;

    /** The fecha fin. */
    private Date ffin;

    /** The fecha referencia. */
    private Date freferencia;

    /** The rgla. */
    private ReglaVO rgla;

    /** The aspc. */
    private AspectoVO aspc;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
    public void setTpsr(TipoServicioVO value) {
        this.tpsr = value;
    }

    /**
     * Gets the srvc.
     *
     * @return the srvc
     */
    public ServicioVO getSrvc() {
        return srvc;
    }

    /**
     * Sets the srvc.
     *
     * @param value
     *            the srvc
     */
    public void setSrvc(ServicioVO value) {
        this.srvc = value;
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
    public void setCrgo(CargoVO value) {
        this.crgo = value;
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
     * Gets the rgla.
     *
     * @return the rgla
     */
    public ReglaVO getRgla() {
        return rgla;
    }

    /**
     * Sets the rgla.
     *
     * @param value
     *            the rgla
     */
    public void setRgla(ReglaVO value) {
        this.rgla = value;
    }

    /**
     * Gets the finicio.
     *
     * @return the finicio
     */
    public Date getFinicio() {
        return finicio;
    }

    /**
     * Sets the finicio.
     *
     * @param value
     *            the finicio
     */
    public void setFinicio(Date value) {
        this.finicio = value;
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
    public void setFfin(Date value) {
        this.ffin = value;
    }

    /**
     * Gets the freferencia.
     *
     * @return the freferencia
     */
    public Date getFreferencia() {
        return freferencia;
    }

    /**
     * Sets the freferencia.
     *
     * @param value
     *            the freferencia
     */
    public void setFreferencia(Date value) {
        this.freferencia = value;
    }

    /**
     * Gets the fliquidacion.
     *
     * @return the fliquidacion
     */
    public Date getFliquidacion() {
        return fliquidacion;
    }

    /**
     * Sets the fliquidacion.
     *
     * @param value
     *            the fliquidacion
     */
    public void setFliquidacion(Date value) {
        this.fliquidacion = value;
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
     *            the new aspc
     */
    public void setAspc(AspectoVO value) {
        this.aspc = value;
    }

}
