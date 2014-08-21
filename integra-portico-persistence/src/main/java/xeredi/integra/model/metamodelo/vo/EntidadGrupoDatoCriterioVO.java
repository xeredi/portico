package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoCriterioVO.
 */
public final class EntidadGrupoDatoCriterioVO {

    /** The enti id. */
    private Long entiId;

    /** The numero. */
    private Integer numero;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     * Gets the numero.
     * 
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     * 
     * @param value
     *            the new numero
     */
    public void setNumero(final Integer value) {
        numero = value;
    }

}
