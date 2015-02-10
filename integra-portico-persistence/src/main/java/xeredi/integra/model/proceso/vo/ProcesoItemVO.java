package xeredi.integra.model.proceso.vo;

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

    /** The tipo. */
    private ItemTipo tipo;

    /** The enti id. */
    private Long entiId;

    /** The etiqueta. */
    private String etiqueta;

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

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public ItemTipo getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param value
     *            the new tipo
     */
    public void setTipo(final ItemTipo value) {
        tipo = value;
    }

    /**
     * Gets the enti id.
     *
     * @return the enti id
     */
    public Long getEntiId() {
        return entiId;
    }

    /**
     * Sets the enti id.
     *
     * @param value
     *            the new enti id
     */
    public void setEntiId(final Long value) {
        entiId = value;
    }

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Sets the etiqueta.
     *
     * @param value
     *            the new etiqueta
     */
    public void setEtiqueta(final String value) {
        etiqueta = value;
    }

}
