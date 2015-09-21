package xeredi.argo.model.item.vo;

import java.util.Date;

import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteCriterioVO.
 */
public final class ItemTramiteCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The item id. */
    private Long itemId;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    public final void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public final Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public final void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

    /**
     * Gets the item id.
     *
     * @return the item id
     */
    public final Long getItemId() {
        return itemId;
    }

    /**
     * Sets the item id.
     *
     * @param value
     *            the new item id
     */
    public final void setItemId(final Long value) {
        itemId = value;
    }
}
