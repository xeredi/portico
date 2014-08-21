package xeredi.integra.model.comun.vo;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.util.GlobalNames;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadDatoCriterioVO.
 */
public final class ItemDatoCriterioVO {

    /** The endt id. */
    private Long itemId;

    /** The endt ids. */
    private Set<Long> itemIds;

    /** The tpdt. */
    private Long tpdtId;

    /** The cantidad entera. */
    private Long cantidadEntera;

    /** The cantidad entera min. */
    private Long cantidadEnteraMin;

    /** The cantidad entera max. */
    private Long cantidadEnteraMax;

    /** The cantidad decimal. */
    private Double cantidadDecimal;

    /** The cantidad decimal min. */
    private Double cantidadDecimalMin;

    /** The cantidad decimal max. */
    private Double cantidadDecimalMax;

    /** The fecha. */
    private Date fecha;

    /** The fecha min. */
    private Date fechaMin;

    /** The fecha max. */
    private Date fechaMax;

    /** The cadena. */
    private Set<String> cadenas;

    /** The cadena. */
    private String cadena;

    /** The prmt id. */
    private Long prmtId;

    /** The prmt etiqueta. */
    private String prmtEtiqueta;

    /** The srvc id. */
    private Long srvcId;

    /** The srvc etiqueta. */
    private String srvcEtiqueta;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Populate search links.
     * 
     * @param map
     *            the map
     * @param fieldnamePrefix
     *            the fieldname prefix
     */
    public void populateSearchLinks(final Map<String, Object> map, final String fieldnamePrefix) {
        map.put(fieldnamePrefix + "tpdtId", tpdtId);

        if (cadena != null && !cadena.isEmpty()) {
            map.put(fieldnamePrefix + "cadena", StringEscapeUtils.escapeHtml4(cadena.trim()));
        }
        if (cantidadDecimal != null) {
            map.put(fieldnamePrefix + "cantidadDecimal", cantidadDecimal);
        }
        if (cantidadDecimalMax != null) {
            map.put(fieldnamePrefix + "cantidadDecimalMax", cantidadDecimalMax);
        }
        if (cantidadDecimalMin != null) {
            map.put(fieldnamePrefix + "cantidadDecimalMin", cantidadDecimalMin);
        }
        if (cantidadEntera != null) {
            map.put(fieldnamePrefix + "cantidadEntera", cantidadEntera);
        }
        if (cantidadEnteraMax != null) {
            map.put(fieldnamePrefix + "cantidadEnteraMax", cantidadEnteraMax);
        }
        if (cantidadEnteraMin != null) {
            map.put(fieldnamePrefix + "cantidadEnteraMin", cantidadEnteraMin);
        }
        if (fecha != null) {
            map.put(fieldnamePrefix + "fecha", GlobalNames.DATETIME_FORMAT.format(fecha));
        }
        if (fechaMax != null) {
            map.put(fieldnamePrefix + "fechaMax", GlobalNames.DATETIME_FORMAT.format(fechaMax));
        }
        if (fechaMin != null) {
            map.put(fieldnamePrefix + "fechaMin", GlobalNames.DATETIME_FORMAT.format(fechaMin));
        }
        if (prmtId != null) {
            map.put(fieldnamePrefix + "prmtId", prmtId);
        }
        if (prmtEtiqueta != null) {
            map.put(fieldnamePrefix + "prmtEtiqueta", StringEscapeUtils.escapeHtml4(prmtEtiqueta));
        }
        if (srvcId != null) {
            map.put(fieldnamePrefix + "srvcId", srvcId);
        }
        if (srvcEtiqueta != null) {
            map.put(fieldnamePrefix + "srvcEtiqueta", StringEscapeUtils.escapeHtml4(srvcEtiqueta));
        }
    }

    /**
     * Gets the booleano.
     * 
     * @return the booleano
     */
    public Boolean getBooleano() {
        return cantidadEntera == null ? null : 1 == cantidadEntera;
    }

    /**
     * Sets the booleano.
     * 
     * @param value
     *            the new booleano
     */
    public void setBooleano(final String value) {
        if (value != null && !value.isEmpty()) {
            cantidadEntera = Boolean.TRUE.toString().equals(value) ? 1L : 0L;
        }
    }

    /**
     * Gets the item id.
     * 
     * @return the item id
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * Sets the item id.
     * 
     * @param value
     *            the new item id
     */
    public void setItemId(final Long value) {
        itemId = value;
    }

    /**
     * Gets the item ids.
     * 
     * @return the item ids
     */
    public Set<Long> getItemIds() {
        return itemIds;
    }

    /**
     * Sets the item ids.
     * 
     * @param value
     *            the new item ids
     */
    public void setItemIds(final Set<Long> value) {
        itemIds = value;
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
     * Gets the cantidad entera.
     * 
     * @return the cantidad entera
     */
    public Long getCantidadEntera() {
        return cantidadEntera;
    }

    /**
     * Sets the cantidad entera.
     * 
     * @param value
     *            the new cantidad entera
     */
    public void setCantidadEntera(final Long value) {
        cantidadEntera = value;
    }

    /**
     * Gets the cantidad entera min.
     * 
     * @return the cantidad entera min
     */
    public Long getCantidadEnteraMin() {
        return cantidadEnteraMin;
    }

    /**
     * Sets the cantidad entera min.
     * 
     * @param value
     *            the new cantidad entera min
     */
    public void setCantidadEnteraMin(final Long value) {
        cantidadEnteraMin = value;
    }

    /**
     * Gets the cantidad entera max.
     * 
     * @return the cantidad entera max
     */
    public Long getCantidadEnteraMax() {
        return cantidadEnteraMax;
    }

    /**
     * Sets the cantidad entera max.
     * 
     * @param value
     *            the new cantidad entera max
     */
    public void setCantidadEnteraMax(final Long value) {
        cantidadEnteraMax = value;
    }

    /**
     * Gets the cantidad decimal.
     * 
     * @return the cantidad decimal
     */
    public Double getCantidadDecimal() {
        return cantidadDecimal;
    }

    /**
     * Sets the cantidad decimal.
     * 
     * @param value
     *            the new cantidad decimal
     */
    public void setCantidadDecimal(final Double value) {
        cantidadDecimal = value;
    }

    /**
     * Gets the cantidad decimal min.
     * 
     * @return the cantidad decimal min
     */
    public Double getCantidadDecimalMin() {
        return cantidadDecimalMin;
    }

    /**
     * Sets the cantidad decimal min.
     * 
     * @param value
     *            the new cantidad decimal min
     */
    public void setCantidadDecimalMin(final Double value) {
        cantidadDecimalMin = value;
    }

    /**
     * Gets the cantidad decimal max.
     * 
     * @return the cantidad decimal max
     */
    public Double getCantidadDecimalMax() {
        return cantidadDecimalMax;
    }

    /**
     * Sets the cantidad decimal max.
     * 
     * @param value
     *            the new cantidad decimal max
     */
    public void setCantidadDecimalMax(final Double value) {
        cantidadDecimalMax = value;
    }

    /**
     * Gets the fecha.
     * 
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Sets the fecha.
     * 
     * @param value
     *            the new fecha
     */
    public void setFecha(final Date value) {
        fecha = value;
    }

    /**
     * Gets the fecha min.
     * 
     * @return the fecha min
     */
    public Date getFechaMin() {
        return fechaMin;
    }

    /**
     * Sets the fecha min.
     * 
     * @param value
     *            the new fecha min
     */
    public void setFechaMin(final Date value) {
        fechaMin = value;
    }

    /**
     * Gets the fecha max.
     * 
     * @return the fecha max
     */
    public Date getFechaMax() {
        return fechaMax;
    }

    /**
     * Sets the fecha max.
     * 
     * @param value
     *            the new fecha max
     */
    public void setFechaMax(final Date value) {
        fechaMax = value;
    }

    /**
     * Gets the cadena.
     * 
     * @return the cadena
     */
    public String getCadena() {
        return cadena;
    }

    /**
     * Sets the cadena.
     * 
     * @param value
     *            the new cadena
     */
    public void setCadena(final String value) {
        cadena = value;
    }

    /**
     * Gets the prmt id.
     * 
     * @return the prmt id
     */
    public Long getPrmtId() {
        return prmtId;
    }

    /**
     * Sets the prmt id.
     * 
     * @param value
     *            the new prmt id
     */
    public void setPrmtId(final Long value) {
        prmtId = value;
    }

    /**
     * Gets the cadenas.
     * 
     * @return the cadenas
     */
    public Set<String> getCadenas() {
        return cadenas;
    }

    /**
     * Sets the cadenas.
     * 
     * @param value
     *            the new cadenas
     */
    public void setCadenas(final Set<String> value) {
        cadenas = value;
    }

    /**
     * Gets the srvc id.
     * 
     * @return the srvc id
     */
    public Long getSrvcId() {
        return srvcId;
    }

    /**
     * Sets the srvc id.
     * 
     * @param value
     *            the new srvc id
     */
    public void setSrvcId(final Long value) {
        srvcId = value;
    }

    /**
     * Gets the prmt etiqueta.
     * 
     * @return the prmt etiqueta
     */
    public String getPrmtEtiqueta() {
        return prmtEtiqueta;
    }

    /**
     * Sets the prmt etiqueta.
     * 
     * @param value
     *            the new prmt etiqueta
     */
    public void setPrmtEtiqueta(final String value) {
        prmtEtiqueta = value;
    }

    /**
     * Gets the srvc etiqueta.
     * 
     * @return the srvc etiqueta
     */
    public String getSrvcEtiqueta() {
        return srvcEtiqueta;
    }

    /**
     * Sets the srvc etiqueta.
     * 
     * @param value
     *            the new srvc etiqueta
     */
    public void setSrvcEtiqueta(final String value) {
        srvcEtiqueta = value;
    }

}
