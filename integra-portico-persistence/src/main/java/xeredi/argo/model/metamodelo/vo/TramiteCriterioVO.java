package xeredi.argo.model.metamodelo.vo;

import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteCriterioVO.
 */
public final class TramiteCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The enti id. */
    private Long entiId;

    /** The estado orig. */
    private String estadoOrig;

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
     * Gets the estado orig.
     *
     * @return the estado orig
     */
    public String getEstadoOrig() {
        return estadoOrig;
    }

    /**
     * Sets the estado orig.
     *
     * @param value
     *            the new estado orig
     */
    public void setEstadoOrig(final String value) {
        estadoOrig = value;
    }
}
