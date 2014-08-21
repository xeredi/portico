package xeredi.integra.model.metamodelo.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.util.pagination.Criterio;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoCriterioVO.
 */
public final class TipoDatoCriterioVO implements Criterio {

    /** The offset. */
    private Integer offset;

    /** The limit. */
    private Integer limit;

    /** The ids. */
    private Set<Long> ids;

    /** The codigo. */
    private String codigo;

    /** The nombre. */
    private String nombre;

    /** The tipo elemento. */
    private TipoElemento tipoElemento;

    /** The tpht id. */
    private TipoHtml tpht;

    /** The tppr id. */
    private Long entiId;

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

        if (codigo != null) {
            map.put("codigo", codigo);
        }
        if (nombre != null) {
            map.put("nombre", nombre);
        }
        if (tpht != null) {
            map.put("tpht", tpht);
        }
        if (tipoElemento != null) {
            map.put("tipoElemento", tipoElemento);
        }
        if (entiId != null) {
            map.put("entiId", entiId);
        }

        return map;
    }

    /**
     * Gets the ids.
     * 
     * @return the ids
     */
    public Set<Long> getIds() {
        return ids;
    }

    /**
     * Sets the ids.
     * 
     * @param value
     *            the new ids
     */
    public void setIds(final Set<Long> value) {
        ids = value;
    }

    /**
     * Gets the nombre.
     * 
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     * 
     * @param value
     *            the new nombre
     */
    public void setNombre(final String value) {
        nombre = value;
    }

    /**
     * Gets the tipo elemento.
     * 
     * @return the tipo elemento
     */
    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    /**
     * Sets the tipo elemento.
     * 
     * @param value
     *            the new tipo elemento
     */
    public void setTipoElemento(final TipoElemento value) {
        tipoElemento = value;
    }

    /**
     * Gets the tpht id.
     * 
     * @return the tpht id
     */
    public TipoHtml getTpht() {
        return tpht;
    }

    /**
     * Sets the tpht id.
     * 
     * @param value
     *            the new tpht id
     */
    public void setTpht(final TipoHtml value) {
        tpht = value;
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
     * Gets the codigo.
     * 
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     * 
     * @param value
     *            the new codigo
     */
    public void setCodigo(final String value) {
        codigo = value;
    }

}
