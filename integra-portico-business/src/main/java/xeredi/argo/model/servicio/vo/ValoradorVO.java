package xeredi.argo.model.servicio.vo;

import java.util.Date;
import java.util.Set;

import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoradorVO.
 */
public final class ValoradorVO {

    /** The enti id. */
    private ServicioVO srvc;

    /** The fliq. */
    private Date fliq;

    /** The crgo ids. */
    private Set<Long> crgoIds;

    /** The prbt. */
    private ProcesoVO prbt;

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
        this.srvc = value;
    }

    /**
     * Gets the fliq.
     *
     * @return the fliq
     */
    public Date getFliq() {
        return fliq;
    }

    /**
     * Sets the fliq.
     *
     * @param value
     *            the new fliq
     */
    public void setFliq(final Date value) {
        this.fliq = value;
    }

    /**
     * Gets the crgo ids.
     *
     * @return the crgo ids
     */
    public Set<Long> getCrgoIds() {
        return crgoIds;
    }

    /**
     * Sets the crgo ids.
     *
     * @param value
     *            the new crgo ids
     */
    public void setCrgoIds(final Set<Long> value) {
        this.crgoIds = value;
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
     *            the new prbt
     */
    public void setPrbt(final ProcesoVO value) {
        this.prbt = value;
    }

}
