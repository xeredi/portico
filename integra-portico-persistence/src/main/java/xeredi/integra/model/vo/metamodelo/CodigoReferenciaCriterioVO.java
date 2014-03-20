package xeredi.integra.model.vo.metamodelo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaCriterioVO.
 */
public final class CodigoReferenciaCriterioVO {

    /** The tpdt ids. */
    private Set<Long> tpdtIds;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the tpdt ids.
     * 
     * @return the tpdt ids
     */
    public Set<Long> getTpdtIds() {
        return tpdtIds;
    }

    /**
     * Sets the tpdt ids.
     * 
     * @param value
     *            the new tpdt ids
     */
    public void setTpdtIds(final Set<Long> value) {
        tpdtIds = value;
    }

}
