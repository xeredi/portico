package xeredi.integra.model.vo.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionAgregadaCriterioVO.
 */
public final class ValoracionAgregadaCriterioVO {

    /** The prbt id. */
    private Long prbtId;

    /** The srvc id. */
    private Long srvcId;

    /** The aspv id. */
    private Long aspvId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     *            the prbt id
     */
    public void setPrbtId(Long value) {
        this.prbtId = value;
    }

    /**
     * Gets the srvc id.
     *
     * @return the srvc id
     */
    public Long getSrvcId() {
        return srvcId;
    }

    /**
     * Sets the srvc id.
     *
     * @param value
     *            the srvc id
     */
    public void setSrvcId(Long value) {
        this.srvcId = value;
    }

    /**
     * Gets the aspv id.
     *
     * @return the aspv id
     */
    public Long getAspvId() {
        return aspvId;
    }

    /**
     * Sets the aspv id.
     *
     * @param value
     *            the aspv id
     */
    public void setAspvId(Long value) {
        this.aspvId = value;
    }

}
