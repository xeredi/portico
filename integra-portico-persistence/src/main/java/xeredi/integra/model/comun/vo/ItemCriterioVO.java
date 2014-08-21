package xeredi.integra.model.comun.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.util.GlobalNames;
import xeredi.util.pagination.Criterio;
import xeredi.util.pagination.PaginableCriterio;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemCriterioVO.
 */
public abstract class ItemCriterioVO implements Criterio, PaginableCriterio {
	/** The offset. */
	private Integer offset;

	/** The limit. */
	private Integer limit;

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
	public final Map<String, Object> getSearchLinks() {
		final Map<String, Object> map = new HashMap<>();

		fillSpecificSearchLinks(map);

		if (idioma != null && !idioma.isEmpty()) {
			map.put("idioma", idioma);
		}
		if (fechaVigencia != null) {
			map.put("fechaVigencia", GlobalNames.DATETIME_FORMAT.format(fechaVigencia));
		}
		if (soloDatosGrid) {
			map.put("soloDatosGrid", soloDatosGrid);
		}

		if (etiqueta != null) {
			map.put("etiqueta", etiqueta);
		}
		if (id != null) {
			map.put("id", id);
		}
		if (ids != null && !ids.isEmpty()) {
			map.put("ids", ids);
		}
		if (entiId != null) {
			map.put("entiId", entiId);
		}
		if (entiIds != null && !entiIds.isEmpty()) {
			map.put("ids", ids);
		}

		if (itdtMap != null) {
			for (final Long tpdtId : itdtMap.keySet()) {
				itdtMap.get(tpdtId).populateSearchLinks(map, "itdtMap[" + tpdtId + "].");
			}
		}

		return map;

	}

	/**
	 * Fill specific search links.
	 * 
	 * @param map
	 *            the map
	 */
	protected abstract void fillSpecificSearchLinks(final Map<String, Object> map);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Integer getOffset() {
		return offset;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setOffset(final Integer value) {
		offset = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Integer getLimit() {
		return limit;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setLimit(final Integer value) {
		limit = value;
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
