package xeredi.integra.model.bo.facturacion;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.vo.facturacion.CargoVO;
import xeredi.integra.model.vo.facturacion.ReglaVO;
import xeredi.integra.model.vo.metamodelo.TipoServicioVO;
import xeredi.integra.model.vo.proceso.ProcesoVO;
import xeredi.integra.model.vo.servicio.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionContextoVO.
 */
public final class ValoracionContextoVO {

    /** The prbt. */
    private ProcesoVO prbt;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The srvc. */
    private ServicioVO srvc;

    /** The crgo. */
    private CargoVO crgo;

    /** The fecha liquidacion. */
    private Date fechaLiquidacion;

    /** The fecha inicio. */
    private Date fechaInicio;

    /** The fecha fin. */
    private Date fechaFin;

    /** The fecha referencia. */
    private Date fechaReferencia;

    /** The rgla. */
    private ReglaVO rgla;

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
     * Gets the fecha liquidacion.
     *
     * @return the fecha liquidacion
     */
    public Date getFechaLiquidacion() {
        return fechaLiquidacion;
    }

    /**
     * Sets the fecha liquidacion.
     *
     * @param value
     *            the fecha liquidacion
     */
    public void setFechaLiquidacion(Date value) {
        this.fechaLiquidacion = value;
    }

    /**
     * Gets the fecha inicio.
     *
     * @return the fecha inicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Sets the fecha inicio.
     *
     * @param value
     *            the fecha inicio
     */
    public void setFechaInicio(Date value) {
        this.fechaInicio = value;
    }

    /**
     * Gets the fecha fin.
     *
     * @return the fecha fin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Sets the fecha fin.
     *
     * @param value
     *            the fecha fin
     */
    public void setFechaFin(Date value) {
        this.fechaFin = value;
    }

    /**
     * Gets the fecha referencia.
     *
     * @return the fecha referencia
     */
    public Date getFechaReferencia() {
        return fechaReferencia;
    }

    /**
     * Sets the fecha referencia.
     *
     * @param value
     *            the fecha referencia
     */
    public void setFechaReferencia(Date value) {
        this.fechaReferencia = value;
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

}
