package xeredi.integra.model.configuracion.vo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ValorIdiomaCriterioVO.
 */
public final class ValorIdiomaCriterioVO {

    /** The cnid id. */
    private Long cnidId;

    /** The cnci id. */
    private Long cnciId;

    /** The cnci ids. */
    private Set<Long> cnciIds;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the cnid id.
     * 
     * @return the cnid id
     */
    public Long getCnidId() {
        return cnidId;
    }

    /**
     * Sets the cnid id.
     * 
     * @param value
     *            the new cnid id
     */
    public void setCnidId(final Long value) {
        cnidId = value;
    }

    /**
     * Gets the cnci id.
     * 
     * @return the cnci id
     */
    public Long getCnciId() {
        return cnciId;
    }

    /**
     * Sets the cnci id.
     * 
     * @param value
     *            the new cnci id
     */
    public void setCnciId(final Long value) {
        cnciId = value;
    }

    /**
     * Gets the cnci ids.
     * 
     * @return the cnci ids
     */
    public Set<Long> getCnciIds() {
        return cnciIds;
    }

    /**
     * Sets the cnci ids.
     * 
     * @param value
     *            the new cnci ids
     */
    public void setCnciIds(final Set<Long> value) {
        cnciIds = value;
    }

}
