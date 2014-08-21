package xeredi.integra.model.configuracion.vo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ValorCriterioVO.
 */
public final class ValorCriterioVO {

    /** The cnen id. */
    private Long cnenId;

    /** The cncl id. */
    private Long cnclId;

    /** The cncl ids. */
    private Set<Long> cnclIds;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the cnen id.
     * 
     * @return the cnen id
     */
    public Long getCnenId() {
        return cnenId;
    }

    /**
     * Sets the cnen id.
     * 
     * @param value
     *            the new cnen id
     */
    public void setCnenId(final Long value) {
        cnenId = value;
    }

    /**
     * Gets the cncl id.
     * 
     * @return the cncl id
     */
    public Long getCnclId() {
        return cnclId;
    }

    /**
     * Sets the cncl id.
     * 
     * @param value
     *            the new cncl id
     */
    public void setCnclId(final Long value) {
        cnclId = value;
    }

    /**
     * Gets the cncl ids.
     * 
     * @return the cncl ids
     */
    public Set<Long> getCnclIds() {
        return cnclIds;
    }

    /**
     * Sets the cncl ids.
     * 
     * @param value
     *            the new cncl ids
     */
    public void setCnclIds(final Set<Long> value) {
        cnclIds = value;
    }

}
