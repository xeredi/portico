package xeredi.integra.model.vo.configuracion;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaveIdiomaVO.
 */
public final class ClaveIdiomaVO {

    /** The id. */
    private Long id;

    /** The clave. */
    private String clave;

    /** The valor defecto. */
    private String valorDefecto;

    /** The cnvi map. */
    private Map<Long, String> cnviMap;

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
     * Gets the cnvi map.
     * 
     * @return the cnvi map
     */
    public Map<Long, String> getCnviMap() {
        return cnviMap;
    }

    /**
     * Sets the cnvi map.
     * 
     * @param value
     *            the value
     */
    public void setCnviMap(final Map<Long, String> value) {
        cnviMap = value;
    }

}
