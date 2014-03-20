package xeredi.integra.model.vo.configuracion;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ValorVO.
 */
public final class ValorVO {

    /** The cnen. */
    private Long cnenId;

    /** The cncl. */
    private Long cnclId;

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

}
