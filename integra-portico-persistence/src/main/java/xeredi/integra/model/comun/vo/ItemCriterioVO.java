package xeredi.integra.model.comun.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.util.pagination.Criterio;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemCriterioVO.
 */
public abstract class ItemCriterioVO implements Criterio {
    /** The idioma. */
    private String idioma;

    /** The fecha vigencia. */
    private Date fechaVigencia;

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
     * Instantiates a new item criterio vo.
     */
    public ItemCriterioVO() {
        super();

        itdtMap = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Fill url map.
     *
     * @param map
     *            the map
     */
    protected void fillUrlMap(final Map<String, Object> map) {
        if (fechaVigencia != null) {
            map.put("itemCriterio.fechaVigencia", fechaVigencia);
        }
        if (idioma != null) {
            map.put("itemCriterio.idioma", idioma);
        }

        map.put("itemCriterio.soloDatosGrid", soloDatosGrid);

        if (etiqueta != null) {
            map.put("itemCriterio.etiqueta", etiqueta);
        }
        if (id != null) {
            map.put("itemCriterio.id", id);
        }
        if (ids != null) {
            map.put("itemCriterio.ids", ids);
        }
        if (entiId != null) {
            map.put("itemCriterio.entiId", entiId);
        }
        if (entiIds != null) {
            map.put("itemCriterio.entiIds", entiIds);
        }

        if (itdtMap != null) {
            for (final ItemDatoCriterioVO itdt : itdtMap.values()) {
                final String prefix = "itemCriterio.itdtMap(" + itdt.getTpdtId() + ")";

                if (itdt.getBooleano() != null) {
                    map.put(prefix + ".booleano", itdt.getBooleano());
                }
                if (itdt.getCadena() != null) {
                    map.put(prefix + ".cadena", itdt.getCadena());
                }
                if (itdt.getCadenas() != null) {
                    map.put(prefix + ".cadenas", itdt.getCadenas());
                }
                if (itdt.getCantidadDecimal() != null) {
                    map.put(prefix + ".cantidadDecimal", itdt.getCantidadDecimal());
                }
                if (itdt.getCantidadDecimalMax() != null) {
                    map.put(prefix + ".cantidadDecimalMax", itdt.getCantidadDecimalMax());
                }
                if (itdt.getCantidadDecimalMin() != null) {
                    map.put(prefix + ".cantidadDecimalMin", itdt.getCantidadDecimalMin());
                }
                if (itdt.getCantidadEntera() != null) {
                    map.put(prefix + ".cantidadEntera", itdt.getCantidadEntera());
                }
                if (itdt.getCantidadEnteraMax() != null) {
                    map.put(prefix + ".cantidadEnteraMax", itdt.getCantidadEnteraMax());
                }
                if (itdt.getCantidadEnteraMin() != null) {
                    map.put(prefix + ".cantidadEnteraMin", itdt.getCantidadEnteraMin());
                }
                if (itdt.getFecha() != null) {
                    map.put(prefix + ".fecha", itdt.getFecha());
                }
                if (itdt.getFechaMax() != null) {
                    map.put(prefix + ".fechaMax", itdt.getFechaMax());
                }
                if (itdt.getFechaMin() != null) {
                    map.put(prefix + ".fechaMin", itdt.getFechaMin());
                }
                if (itdt.getItemId() != null) {
                    map.put(prefix + ".itemId", itdt.getItemId());
                }
                if (itdt.getItemIds() != null) {
                    map.put(prefix + ".itemIds", itdt.getItemIds());
                }
                if (itdt.getPrmt() != null && itdt.getPrmt().getId() != null) {
                    map.put(prefix + ".prmt.id", itdt.getPrmt().getId());
                }
                if (itdt.getSrvc() != null && itdt.getSrvc().getId() != null) {
                    map.put(prefix + ".srvc.id", itdt.getSrvc().getId());
                }
            }
        }
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
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public final Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public final void setFechaVigencia(final Date value) {
        fechaVigencia = value;
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

}
