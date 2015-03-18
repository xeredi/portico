package xeredi.integra.model.maestro.vo;

import xeredi.integra.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroLupaCriterioVO.
 */
public final class ParametroLupaCriterioVO extends BaseCriterioVO {
    /** The enti id. */
    private Long entiId;

    /** The tpdt nombre id. */
    private Long tpdtNombreId;

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
     * Gets the tpdt nombre id.
     *
     * @return the tpdt nombre id
     */
    public final Long getTpdtNombreId() {
        return tpdtNombreId;
    }

    /**
     * Sets the tpdt nombre id.
     *
     * @param value
     *            the new tpdt nombre id
     */
    public final void setTpdtNombreId(final Long value) {
        tpdtNombreId = value;
    }

}
