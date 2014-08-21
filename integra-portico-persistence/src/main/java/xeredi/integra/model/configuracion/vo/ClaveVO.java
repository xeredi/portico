package xeredi.integra.model.configuracion.vo;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaveVO.
 */
public final class ClaveVO {

    /** The id. */
    private Long id;

    /** The tipo valor. */
    private TipoValor tipoValor;

    /** The clave. */
    private String clave;

    /** The valor defecto. */
    private String valorDefecto;

    /** The cnvl map. */
    private Map<Long, String> cnvlMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param value
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
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
     * Gets the cnvl map.
     * 
     * @return the cnvl map
     */
    public Map<Long, String> getCnvlMap() {
        return cnvlMap;
    }

    /**
     * Sets the cnvl map.
     * 
     * @param value
     *            the value
     */
    public void setCnvlMap(final Map<Long, String> value) {
        cnvlMap = value;
    }

}
