package xeredi.argo.model.facturacion.vo;

import java.util.Calendar;

import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorVO.
 */
public final class FacturadorVO {

    /** The fcsr. */
    private Long fcsrId;

    /** The fecha facturacion. */
    private Calendar fecha;

    /** The tpsr. */
    private Long tpsrId;

    /** The prto. */
    private Long prtoId;

    /** The srvc. */
    private ServicioVO srvc;

    /** The vlrc. */
    private ValoracionVO vlrc;

    /** The pagador. */
    private ParametroVO pagador;

    /** The prbt id. */
    private Long prbtId;

    /**
     * Gets the tpsr.
     *
     * @return the tpsr
     */
    public Long getTpsrId() {
        return tpsrId;
    }

    /**
     * Sets the tpsr.
     *
     * @param value
     *            the new tpsr
     */
    public void setTpsrId(final Long value) {
        tpsrId = value;
    }

    /**
     * Gets the prto.
     *
     * @return the prto
     */
    public Long getPrtoId() {
        return prtoId;
    }

    /**
     * Sets the prto.
     *
     * @param value
     *            the new prto
     */
    public void setPrtoId(final Long value) {
        prtoId = value;
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
     *            the new srvc
     */
    public void setSrvc(final ServicioVO value) {
        srvc = value;
    }

    /**
     * Gets the vlrc.
     *
     * @return the vlrc
     */
    public ValoracionVO getVlrc() {
        return vlrc;
    }

    /**
     * Sets the vlrc.
     *
     * @param value
     *            the new vlrc
     */
    public void setVlrc(final ValoracionVO value) {
        vlrc = value;
    }

    /**
     * Gets the pagador.
     *
     * @return the pagador
     */
    public ParametroVO getPagador() {
        return pagador;
    }

    /**
     * Sets the pagador.
     *
     * @param value
     *            the new pagador
     */
    public void setPagador(final ParametroVO value) {
        pagador = value;
    }

    /**
     * Gets the fcsr.
     *
     * @return the fcsr
     */
    public Long getFcsrId() {
        return fcsrId;
    }

    /**
     * Sets the fcsr.
     *
     * @param value
     *            the new fcsr
     */
    public void setFcsrId(final Long value) {
        fcsrId = value;
    }

    /**
     * Gets the fecha facturacion.
     *
     * @return the fecha facturacion
     */
    public Calendar getFecha() {
        return fecha;
    }

    /**
     * Sets the fecha facturacion.
     *
     * @param value
     *            the new fecha facturacion
     */
    public void setFecha(final Calendar value) {
        fecha = value;
    }

    /**
     * Gets the prbt id.
     *
     * @return the prbt id
     */
    public Long getPrbtId() {
        return prbtId;
    }

    /**
     * Sets the prbt id.
     *
     * @param value
     *            the new prbt id
     */
    public void setPrbtId(final Long value) {
        prbtId = value;
    }
}
