package xeredi.integra.model.configuracion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ValorIdiomaVO.
 */
public final class ValorIdiomaVO {

    /** The cnid. */
    private Long cnidId;

    /** The cncl. */
    private Long cnciId;

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
     *            the new valor
     */
    public void setValor(final String value) {
        valor = value;
    }

}
