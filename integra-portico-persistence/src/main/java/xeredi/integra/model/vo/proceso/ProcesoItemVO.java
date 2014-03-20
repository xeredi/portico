package xeredi.integra.model.vo.proceso;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoItemVO.
 */
public final class ProcesoItemVO {

    /** The prbt id. */
    private Long prbtId;

    /** The sentido. */
    private ItemSentido sentido;

    /** The item id. */
    private Long itemId;

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

    /**
     * Gets the item id.
     * 
     * @return the item id
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * Sets the item id.
     * 
     * @param value
     *            the new item id
     */
    public void setItemId(final Long value) {
        itemId = value;
    }

}
