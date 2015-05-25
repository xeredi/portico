package xeredi.integra.model.item.vo;

import java.util.Date;

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

    /** The onentero. */
    private Long onentero;

    /** The ondecimal. */
    private Double ondecimal;

    /** The ocadena. */
    private String ocadena;

    /** The ofecha. */
    private Date ofecha;

    /** The oprmt. */
    private ParametroVO oprmt;

    /** The osrvc. */
    private ServicioVO osrvc;

    /** The dnentero. */
    private Long dnentero;

    /** The dndecimal. */
    private Double dndecimal;

    /** The dcadena. */
    private String dcadena;

    /** The dfecha. */
    private Date dfecha;

    /** The dprmt. */
    private ParametroVO dprmt;

    /** The dsrvc. */
    private ServicioVO dsrvc;

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
    public final Long getIttrId() {
        return ittrId;
    }

    /**
     * Sets the ittr id.
     *
     * @param value
     *            the new ittr id
     */
    public final void setIttrId(final Long value) {
        ittrId = value;
    }

    /**
     * Gets the tpdt id.
     *
     * @return the tpdt id
     */
    public final Long getTpdtId() {
        return tpdtId;
    }

    /**
     * Sets the tpdt id.
     *
     * @param value
     *            the new tpdt id
     */
    public final void setTpdtId(final Long value) {
        tpdtId = value;
    }

    /**
     * Gets the onentero.
     *
     * @return the onentero
     */
    public final Long getOnentero() {
        return onentero;
    }

    /**
     * Sets the onentero.
     *
     * @param value
     *            the new onentero
     */
    public final void setOnentero(final Long value) {
        onentero = value;
    }

    /**
     * Gets the ondecimal.
     *
     * @return the ondecimal
     */
    public final Double getOndecimal() {
        return ondecimal;
    }

    /**
     * Sets the ondecimal.
     *
     * @param value
     *            the new ondecimal
     */
    public final void setOndecimal(final Double value) {
        ondecimal = value;
    }

    /**
     * Gets the ocadena.
     *
     * @return the ocadena
     */
    public final String getOcadena() {
        return ocadena;
    }

    /**
     * Sets the ocadena.
     *
     * @param value
     *            the new ocadena
     */
    public final void setOcadena(final String value) {
        ocadena = value;
    }

    /**
     * Gets the ofecha.
     *
     * @return the ofecha
     */
    public final Date getOfecha() {
        return ofecha;
    }

    /**
     * Sets the ofecha.
     *
     * @param value
     *            the new ofecha
     */
    public final void setOfecha(final Date value) {
        ofecha = value;
    }

    /**
     * Gets the oprmt.
     *
     * @return the oprmt
     */
    public final ParametroVO getOprmt() {
        return oprmt;
    }

    /**
     * Sets the oprmt.
     *
     * @param value
     *            the new oprmt
     */
    public final void setOprmt(final ParametroVO value) {
        oprmt = value;
    }

    /**
     * Gets the osrvc.
     *
     * @return the osrvc
     */
    public final ServicioVO getOsrvc() {
        return osrvc;
    }

    /**
     * Sets the osrvc.
     *
     * @param value
     *            the new osrvc
     */
    public final void setOsrvc(final ServicioVO value) {
        osrvc = value;
    }

    /**
     * Gets the dnentero.
     *
     * @return the dnentero
     */
    public final Long getDnentero() {
        return dnentero;
    }

    /**
     * Sets the dnentero.
     *
     * @param value
     *            the new dnentero
     */
    public final void setDnentero(final Long value) {
        dnentero = value;
    }

    /**
     * Gets the dndecimal.
     *
     * @return the dndecimal
     */
    public final Double getDndecimal() {
        return dndecimal;
    }

    /**
     * Sets the dndecimal.
     *
     * @param value
     *            the new dndecimal
     */
    public final void setDndecimal(final Double value) {
        dndecimal = value;
    }

    /**
     * Gets the dcadena.
     *
     * @return the dcadena
     */
    public final String getDcadena() {
        return dcadena;
    }

    /**
     * Sets the dcadena.
     *
     * @param value
     *            the new dcadena
     */
    public final void setDcadena(final String value) {
        dcadena = value;
    }

    /**
     * Gets the dfecha.
     *
     * @return the dfecha
     */
    public final Date getDfecha() {
        return dfecha;
    }

    /**
     * Sets the dfecha.
     *
     * @param value
     *            the new dfecha
     */
    public final void setDfecha(final Date value) {
        dfecha = value;
    }

    /**
     * Gets the dprmt.
     *
     * @return the dprmt
     */
    public final ParametroVO getDprmt() {
        return dprmt;
    }

    /**
     * Sets the dprmt.
     *
     * @param value
     *            the new dprmt
     */
    public final void setDprmt(final ParametroVO value) {
        dprmt = value;
    }

    /**
     * Gets the dsrvc.
     *
     * @return the dsrvc
     */
    public final ServicioVO getDsrvc() {
        return dsrvc;
    }

    /**
     * Sets the dsrvc.
     *
     * @param value
     *            the new dsrvc
     */
    public final void setDsrvc(final ServicioVO value) {
        dsrvc = value;
    }
}
