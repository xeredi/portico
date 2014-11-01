package xeredi.integra.model.comun.vo;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemCriterioVO.
 */
/**
 * @author xeredi
 * 
 */
public abstract class ItemCriterioVO {
    /** The idioma. */
    private String idioma;

    /** The max limit. */
    private Integer maxLimit;

    /** The limit. */
    private Integer limit;

    /** The offset. */
    private Integer offset;

    /** The solo gridables. */
    private boolean soloDatosGrid;

    /** The etiqueta. */
    private String etiqueta;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The enti id. */
    private Long entiId;

    /** The enti ids. */
    private Set<Long> entiIds;

    /** The itdt map. */
    private Map<Long, ItemDatoCriterioVO> itdtMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the idioma.
     * 
     * @return the idioma
     */
    public final String getIdioma() {
        return idioma;
    }

    /**
     * Sets the idioma.
     * 
     * @param value
     *            the new idioma
     */
    public final void setIdioma(final String value) {
        idioma = value;
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
    public final void setId(final Long value) {
        id = value;
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
     * Gets the enti id.
     * 
     * @return the enti id
     */
    public final Long getEntiId() {
        return entiId;
    }

    /**
     * Sets the enti id.
     * 
     * @param value
     *            the new enti id
     */
    public final void setEntiId(final Long value) {
        entiId = value;
    }

    /**
     * Gets the enti ids.
     * 
     * @return the enti ids
     */
    public final Set<Long> getEntiIds() {
        return entiIds;
    }

    /**
     * Sets the enti ids.
     * 
     * @param value
     *            the new enti ids
     */
    public final void setEntiIds(final Set<Long> value) {
        entiIds = value;
    }

    /**
     * Checks if is solo gridables.
     * 
     * @return true, if is solo gridables
     */
    public final boolean isSoloDatosGrid() {
        return soloDatosGrid;
    }

    /**
     * Sets the solo gridables.
     * 
     * @param value
     *            the new solo gridables
     */
    public final void setSoloDatosGrid(final boolean value) {
        soloDatosGrid = value;
    }

    /**
     * Gets the itdt map.
     * 
     * @return the itdt map
     */
    public final Map<Long, ItemDatoCriterioVO> getItdtMap() {
        return itdtMap;
    }

    /**
     * Sets the itdt map.
     * 
     * @param value
     *            the value
     */
    public final void setItdtMap(final Map<Long, ItemDatoCriterioVO> value) {
        itdtMap = value;

        if (itdtMap != null) {
            for (final Object key : itdtMap.keySet()) {
                if (key instanceof Long) {
                    itdtMap.get(key).setTpdtId((Long) key);
                } else {
                    itdtMap.get(key).setTpdtId(Long.valueOf(key.toString()));
                }
            }
        }
    }

    /**
     * Gets the etiqueta.
     * 
     * @return the etiqueta
     */
    public final String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Sets the etiqueta.
     * 
     * @param value
     *            the new etiqueta
     */
    public final void setEtiqueta(final String value) {
        etiqueta = value;
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
     * Gets the max limit.
     * 
     * @return the max limit
     */
    public Integer getMaxLimit() {
        return maxLimit;
    }

    /**
     * Sets the max limit.
     * 
     * @param value
     *            the new max limit
     */
    public void setMaxLimit(final Integer value) {
        maxLimit = value;
    }

}
