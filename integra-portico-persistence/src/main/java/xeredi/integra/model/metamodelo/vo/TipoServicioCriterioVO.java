package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioCriterioVO.
 */
public final class TipoServicioCriterioVO extends EntidadCriterioVO {

    /** The facturable. */
    private Boolean facturable;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the facturable.
     *
     * @return the facturable
     */
    public Boolean getFacturable() {
        return facturable;
    }

    /**
     * Sets the facturable.
     *
     * @param value
     *            the new facturable
     */
    public void setFacturable(final Boolean value) {
        facturable = value;
    }

}
