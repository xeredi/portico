package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioCriterioVO.
 */
public final class TipoSubservicioCriterioVO extends EntidadCriterioVO {
    /** The tpsr id. */
    private Long tpsrId;

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

    /**
     * Gets the tpsr id.
     *
     * @return the tpsr id
     */
    public Long getTpsrId() {
        return tpsrId;
    }

    /**
     * Sets the tpsr id.
     *
     * @param value
     *            the new tpsr id
     */
    public void setTpsrId(final Long value) {
        tpsrId = value;
    }

}
