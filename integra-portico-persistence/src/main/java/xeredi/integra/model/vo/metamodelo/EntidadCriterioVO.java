package xeredi.integra.model.vo.metamodelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.util.pagination.Criterio;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadCriterioVO.
 */
public class EntidadCriterioVO implements Criterio {

    /** The offset. */
    private Integer offset;

    /** The limit. */
    private Integer limit;

    /** The ids. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The tipo. */
    private TipoEntidad tipo;

    /** The codigos. */
    private String codigo;

    /** The nombre. */
    private String nombre;

    /** The enti padre id. */
    private Long entiPadreId;

    /** The enti hija id. */
    private Long entiHijaId;

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

        return map;
    }

    /**
     * Gets the ids.
     * 
     * @return the ids
     */
    public final Set<Long> getIds() {
        return ids;
    }

    /**
     * Sets the ids.
     * 
     * @param value
     *            the new ids
     */
    public final void setIds(final Set<Long> value) {
        ids = value;
    }

    /**
     * Gets the tipo.
     * 
     * @return the tipo
     */
    public final TipoEntidad getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     * 
     * @param value
     *            the new tipo
     */
    public final void setTipo(final TipoEntidad value) {
        tipo = value;
    }

    /**
     * Gets the codigos.
     * 
     * @return the codigos
     */
    public final String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigos.
     * 
     * @param value
     *            the new codigos
     */
    public final void setCodigo(final String value) {
        codigo = value;
    }

    /**
     * Gets the nombre.
     * 
     * @return the nombre
     */
    public final String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     * 
     * @param value
     *            the new nombre
     */
    public final void setNombre(final String value) {
        nombre = value;
    }

    /**
     * Gets the enti padre id.
     * 
     * @return the enti padre id
     */
    public final Long getEntiPadreId() {
        return entiPadreId;
    }

    /**
     * Sets the enti padre id.
     * 
     * @param value
     *            the new enti padre id
     */
    public final void setEntiPadreId(final Long value) {
        entiPadreId = value;
    }

    /**
     * Gets the enti hija id.
     * 
     * @return the enti hija id
     */
    public final Long getEntiHijaId() {
        return entiHijaId;
    }

    /**
     * Sets the enti hija id.
     * 
     * @param value
     *            the new enti hija id
     */
    public final void setEntiHijaId(final Long value) {
        entiHijaId = value;
    }

    /**
     * Gets the offset.
     * 
     * @return the offset
     */
    public final Integer getOffset() {
        return offset;
    }

    /**
     * Sets the offset.
     * 
     * @param value
     *            the new offset
     */
    public final void setOffset(final Integer value) {
        offset = value;
    }

    /**
     * Gets the limit.
     * 
     * @return the limit
     */
    public final Integer getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     * 
     * @param value
     *            the new limit
     */
    public final void setLimit(final Integer value) {
        limit = value;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param value
     *            the new id
     */
    public final void setId(Long value) {
        this.id = value;
    }

}
