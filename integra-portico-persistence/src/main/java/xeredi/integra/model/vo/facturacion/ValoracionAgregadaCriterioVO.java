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
    private AspectoVO aspc;

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
     * @param value the aspc
     */
    public void setAspc(AspectoVO value) {
        this.aspc = value;
    }

}
