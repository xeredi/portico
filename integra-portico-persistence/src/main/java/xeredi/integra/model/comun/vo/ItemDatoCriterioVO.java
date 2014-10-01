package xeredi.integra.model.comun.vo;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

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
    private ParametroVO prmt;

    /** The srvc id. */
    private ServicioVO srvc;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     * Gets the prmt.
     *
     * @return the prmt
     */
    public ParametroVO getPrmt() {
        return prmt;
    }

    /**
     * Sets the prmt.
     *
     * @param value
     *            the new prmt
     */
    public void setPrmt(final ParametroVO value) {
        prmt = value;
    }

    /**
     * Gets the srvc.
     *
     * @return the srvc
     */
    public ServicioVO getSrvc() {
        return srvc;
    }

    /**
     * Sets the srvc.
     *
     * @param value
     *            the new srvc
     */
    public void setSrvc(final ServicioVO value) {
        srvc = value;
    }

}
