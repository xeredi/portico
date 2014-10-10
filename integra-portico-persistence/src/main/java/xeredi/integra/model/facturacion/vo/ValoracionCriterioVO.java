package xeredi.integra.model.facturacion.vo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionCriterioVO.
 */
public final class ValoracionCriterioVO {

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The tpsr id. */
    private Long tpsrId;

    /** The srvc id. */
    private ServicioVO srvc;

    /** The pagador id. */
    private ParametroVO pagador;

    /** The aspc. */
    private AspectoVO aspc;

    /** The crgo. */
    private CargoVO crgo;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

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

}
