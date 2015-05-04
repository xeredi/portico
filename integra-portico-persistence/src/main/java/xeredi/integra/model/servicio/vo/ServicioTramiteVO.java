package xeredi.integra.model.servicio.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioTramiteVO.
 */
public final class ServicioTramiteVO {

    /** The id. */
    private Long id;

    /** The srvc id. */
    private Long srvcId;

    /** The trmt. */
    private TramiteVO trmt;

    /** The fecha. */
    private Date fecha;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     * Gets the trmt.
     *
     * @return the trmt
     */
    public TramiteVO getTrmt() {
        return trmt;
    }

    /**
     * Sets the trmt.
     *
     * @param value
     *            the new trmt
     */
    public void setTrmt(final TramiteVO value) {
        trmt = value;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
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
}
