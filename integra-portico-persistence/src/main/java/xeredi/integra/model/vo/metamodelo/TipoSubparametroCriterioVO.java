package xeredi.integra.model.vo.metamodelo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroCriterioVO.
 */
public final class TipoSubparametroCriterioVO extends EntidadCriterioVO {

    /** The tppr id. */
    private Long tpprId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the tppr id.
     * 
     * @return the tppr id
     */
    public Long getTpprId() {
        return tpprId;
    }

    /**
     * Sets the tppr id.
     * 
     * @param value
     *            the new tppr id
     */
    public void setTpprId(final Long value) {
        tpprId = value;
    }

}
