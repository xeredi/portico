package xeredi.argo.model.metamodelo.vo;

import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadCriterioVO.
 */
public final class EntidadEntidadCriterioVO extends BaseCriterioVO {

    /** The enti padre id. */
    private Long entiPadreId;

    /** The enti hija id. */
    private Long entiHijaId;

    /**
     * Gets the enti padre id.
     *
     * @return the enti padre id
     */
    public Long getEntiPadreId() {
        return entiPadreId;
    }

    /**
     * Sets the enti padre id.
     *
     * @param value
     *            the new enti padre id
     */
    public void setEntiPadreId(final Long value) {
        entiPadreId = value;
    }

    /**
     * Gets the enti hija id.
     *
     * @return the enti hija id
     */
    public Long getEntiHijaId() {
        return entiHijaId;
    }

    /**
     * Sets the enti hija id.
     *
     * @param value
     *            the new enti hija id
     */
    public void setEntiHijaId(final Long value) {
        entiHijaId = value;
    }

}
