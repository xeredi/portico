package xeredi.argo.model.servicio.vo.manifiesto;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoTotalCriterioVO.
 */
public final class ResumenTotalesCriterioVO {

    /** The mani id. */
    private Long maniId;

    /** The bl id. */
    private Long blId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the mani id.
     * 
     * @return the mani id
     */
    public Long getManiId() {
        return maniId;
    }

    /**
     * Sets the mani id.
     * 
     * @param value
     *            the new mani id
     */
    public void setManiId(final Long value) {
        maniId = value;
    }

    /**
     * Gets the bl id.
     * 
     * @return the bl id
     */
    public Long getBlId() {
        return blId;
    }

    /**
     * Sets the bl id.
     * 
     * @param value
     *            the new bl id
     */
    public void setBlId(final Long value) {
        blId = value;
    }

}
