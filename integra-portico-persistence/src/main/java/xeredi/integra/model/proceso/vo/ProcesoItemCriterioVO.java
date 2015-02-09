package xeredi.integra.model.proceso.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoItemCriterioVO.
 */
public final class ProcesoItemCriterioVO {

    /** The prbt id. */
    private Long prbtId;

    /** The sentido. */
    private ItemSentido sentido;

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
     *            the new prbt id
     */
    public void setPrbtId(final Long value) {
        prbtId = value;
    }

    /**
     * Gets the sentido.
     *
     * @return the sentido
     */
    public ItemSentido getSentido() {
        return sentido;
    }

    /**
     * Sets the sentido.
     *
     * @param value
     *            the new sentido
     */
    public void setSentido(final ItemSentido value) {
        sentido = value;
    }

}
