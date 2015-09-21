package xeredi.argo.model.metamodelo.vo;

import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroTipoDatoCriterioVO.
 */
public final class EntidadTipoDatoCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The tppr id. */
    private Long entiId;

    /** The tpdt id. */
    private Long tpdtId;

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
     * Gets the tpdt id.
     *
     * @return the tpdt id
     */
    public Long getTpdtId() {
        return tpdtId;
    }

    /**
     * Sets the tpdt id.
     *
     * @param value
     *            the new tpdt id
     */
    public void setTpdtId(final Long value) {
        tpdtId = value;
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
}
