package xeredi.integra.model.configuracion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.util.pagination.Criterio;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaveCriterioVO.
 */
public final class ClaveCriterioVO implements Criterio {

    /** The offset. */
    private Integer offset;

    /** The limit. */
    private Integer limit;

    /** The clave. */
    private String clave;

    /** The tipo valor. */
    private TipoValor tipoValor;

    /** The valor defecto. */
    private String valorDefecto;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the offset.
     *
     * @return the offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Sets the offset.
     *
     * @param value
     *            the new offset
     */
    public void setOffset(final Integer value) {
        offset = value;
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     *
     * @param value
     *            the new limit
     */
    public void setLimit(final Integer value) {
        limit = value;
    }

    /**
     * Gets the clave.
     *
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Sets the clave.
     *
     * @param value
     *            the new clave
     */
    public void setClave(final String value) {
        clave = value;
    }

    /**
     * Gets the tipo valor.
     *
     * @return the tipo valor
     */
    public TipoValor getTipoValor() {
        return tipoValor;
    }

    /**
     * Sets the tipo valor.
     *
     * @param value
     *            the new tipo valor
     */
    public void setTipoValor(final TipoValor value) {
        tipoValor = value;
    }

    /**
     * Gets the valor defecto.
     *
     * @return the valor defecto
     */
    public String getValorDefecto() {
        return valorDefecto;
    }

    /**
     * Sets the valor defecto.
     *
     * @param value
     *            the new valor defecto
     */
    public void setValorDefecto(final String value) {
        valorDefecto = value;
    }

}
