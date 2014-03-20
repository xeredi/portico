package xeredi.integra.model.vo.metamodelo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaVO.
 */
public final class CodigoReferenciaVO {

    /** The dominio id. */
    private Long tpdtId;

    /** The valor. */
    private String valor;

    /** The orden. */
    private Integer orden;

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
     *            the new tpdt id
     */
    public void setTpdtId(final Long value) {
        tpdtId = value;
    }

    /**
     * Gets the orden.
     * 
     * @return the orden
     */
    public Integer getOrden() {
        return orden;
    }

    /**
     * Sets the orden.
     * 
     * @param value
     *            the new orden
     */
    public void setOrden(final Integer value) {
        orden = value;
    }

}
