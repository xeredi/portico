package xeredi.integra.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteDatoVO.
 */
public final class ItemTramiteDatoVO {

    /** The ittr id. */
    private Long ittrId;

    /** The tpdt id. */
    private Long tpdtId;

    /** The nentero. */
    private Long nentero;

    /** The ndecimal. */
    private Double ndecimal;

    /** The cadena. */
    private String cadena;

    /** The prmt. */
    private ParametroVO prmt;

    /** The srvc. */
    private ServicioVO srvc;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the ittr id.
     *
     * @return the ittr id
     */
    public Long getIttrId() {
        return ittrId;
    }

    /**
     * Sets the ittr id.
     *
     * @param value
     *            the new ittr id
     */
    public void setIttrId(final Long value) {
        ittrId = value;
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
     * Gets the nentero.
     *
     * @return the nentero
     */
    public Long getNentero() {
        return nentero;
    }

    /**
     * Sets the nentero.
     *
     * @param value
     *            the new nentero
     */
    public void setNentero(final Long value) {
        nentero = value;
    }

    /**
     * Gets the ndecimal.
     *
     * @return the ndecimal
     */
    public Double getNdecimal() {
        return ndecimal;
    }

    /**
     * Sets the ndecimal.
     *
     * @param value
     *            the new ndecimal
     */
    public void setNdecimal(final Double value) {
        ndecimal = value;
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
