package xeredi.integra.model.facturacion.vo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioCargoCriterioVO.
 */
public final class ServicioCargoCriterioVO {

    /** The vlrc ids. */
    private Set<Long> vlrcIds;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the vlrc ids.
     *
     * @return the vlrc ids
     */
    public Set<Long> getVlrcIds() {
        return vlrcIds;
    }

    /**
     * Sets the vlrc ids.
     *
     * @param value the vlrc ids
     */
    public void setVlrcIds(final Set<Long> value) {
        this.vlrcIds = value;
    }


}
