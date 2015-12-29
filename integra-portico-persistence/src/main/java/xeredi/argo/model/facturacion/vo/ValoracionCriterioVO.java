package xeredi.argo.model.facturacion.vo;

import java.util.Set;

import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionCriterioVO.
 */
public final class ValoracionCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The tpsr id. */
    private Long tpsrId;

    /** The prto id. */
    private Long prtoId;

    /** The srvc id. */
    private ServicioVO srvc;

    /** The pagador id. */
    private ParametroVO pagador;

    /** The aspc. */
    private AspectoVO aspc;

    /** The crgo. */
    private CargoVO crgo;

    /** The fctr. */
    private FacturaVO fctr;

    /** The cod exencion. */
    private String codExencion;

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
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the ids.
     *
     * @return the ids
     */
    public Set<Long> getIds() {
        return ids;
    }

    /**
     * Sets the ids.
     *
     * @param value
     *            the ids
     */
    public void setIds(final Set<Long> value) {
        ids = value;
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
     * Gets the pagador id.
     *
     * @return the pagador id
     */
    public ParametroVO getPagador() {
        return pagador;
    }

    /**
     * Sets the pagador id.
     *
     * @param value
     *            the new pagador id
     */
    public void setPagador(final ParametroVO value) {
        pagador = value;
    }

    /**
     * Gets the tpsr id.
     *
     * @return the tpsr id
     */
    public Long getTpsrId() {
        return tpsrId;
    }

    /**
     * Sets the tpsr id.
     *
     * @param value
     *            the new tpsr id
     */
    public void setTpsrId(final Long value) {
        tpsrId = value;
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
    public void setAspc(final AspectoVO value) {
        aspc = value;
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
     *            the new crgo
     */
    public void setCrgo(final CargoVO value) {
        crgo = value;
    }

    /**
     * Gets the cod exencion.
     *
     * @return the cod exencion
     */
    public String getCodExencion() {
        return codExencion;
    }

    /**
     * Sets the cod exencion.
     *
     * @param value
     *            the new cod exencion
     */
    public void setCodExencion(final String value) {
        codExencion = value;
    }

    /**
     * Gets the fctr.
     *
     * @return the fctr
     */
    public FacturaVO getFctr() {
        return fctr;
    }

    /**
     * Sets the fctr.
     *
     * @param value
     *            the new fctr
     */
    public void setFctr(final FacturaVO value) {
        fctr = value;
    }

    /**
     * Gets the prto id.
     *
     * @return the prto id
     */
    public Long getPrtoId() {
        return prtoId;
    }

    /**
     * Sets the prto id.
     *
     * @param value
     *            the new prto id
     */
    public void setPrtoId(final Long value) {
        prtoId = value;
    }
}
