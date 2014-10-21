package xeredi.integra.model.comun.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadDatoVO.
 */
public final class ItemDatoVO {
    /** The srvc id. */
    private Long itemId;

    /** The tpdt id. */
    private Long tpdtId;

    /** The cantidad entera. */
    private Long cantidadEntera;

    /** The cantidad decimal. */
    private Double cantidadDecimal;

    /** The fecha. */
    private Date fecha;

    /** The prmt. */
    private ParametroVO prmt;

    /** The srvc. */
    private ServicioVO srvc;

    /** The cadena. */
    private String cadena;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
