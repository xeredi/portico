package xeredi.integra.model.metamodelo.vo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaCriterioVO.
 */
public final class CodigoReferenciaCriterioVO {

    /** The tpdt id. */
    private Long tpdtId;

    /** The tpdt ids. */
    private Set<Long> tpdtIds;

    /** The valor. */
    private String valor;

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

    /**
     * Gets the tpdt id.
     *
     * @return the tpdt id
     */
    public Long getTpdtId() {
        return tpdtId;
    }

    /**
     * Sets the tpdt id.
     *
     * @param value
     *            the tpdt id
     */
    public void setTpdtId(Long value) {
        this.tpdtId = value;
    }

    /**
     * Gets the valor.
     *
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * Sets the valor.
     *
     * @param value
     *            the valor
     */
    public void setValor(String value) {
        this.valor = value;
    }

}
