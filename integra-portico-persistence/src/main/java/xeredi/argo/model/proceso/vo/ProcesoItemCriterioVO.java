package xeredi.argo.model.proceso.vo;

import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoItemCriterioVO.
 */
public final class ProcesoItemCriterioVO extends BaseCriterioVO {

    /** The prbt id. */
    private Long prbtId;

    /** The sentido. */
    private ItemSentido sentido;

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
