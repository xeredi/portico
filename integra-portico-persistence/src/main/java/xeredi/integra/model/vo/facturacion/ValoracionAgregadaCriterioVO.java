package xeredi.integra.model.vo.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionAgregadaCriterioVO.
 */
public final class ValoracionAgregadaCriterioVO {

    /** The prbt id. */
    private Long prbtId;

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

}
