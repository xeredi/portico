package xeredi.integra.model.vo.configuracion;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.util.pagination.Criterio;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaveIdiomaCriterioVO.
 */
public final class ClaveIdiomaCriterioVO implements Criterio {

    /** The offset. */
    private Integer offset;

    /** The limit. */
    private Integer limit;

    /** The clave. */
    private String clave;

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
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> getSearchLinks() {
        final Map<String, Object> map = new HashMap<>();

        if (clave != null) {
            map.put("clave", clave);
        }
        if (valorDefecto != null) {
            map.put("valorDefecto", valorDefecto);
        }

        return map;
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
