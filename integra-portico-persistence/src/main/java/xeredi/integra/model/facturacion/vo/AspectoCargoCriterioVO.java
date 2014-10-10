package xeredi.integra.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoCriterioVO.
 */
public final class AspectoCargoCriterioVO {

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The id. */
    private Long id;

    /** The ascv id. */
    private Long ascvId;

    /** The aspc id. */
    private Long aspcId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
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
     * Gets the aspc id.
     *
     * @return the aspc id
     */
    public Long getAspcId() {
        return aspcId;
    }

    /**
     * Sets the aspc id.
     *
     * @param value
     *            the new aspc id
     */
    public void setAspcId(final Long value) {
        aspcId = value;
    }

    /**
     * Gets the ascv id.
     *
     * @return the ascv id
     */
    public Long getAscvId() {
        return ascvId;
    }

    /**
     * Sets the ascv id.
     *
     * @param value
     *            the new ascv id
     */
    public void setAscvId(final Long value) {
        ascvId = value;
    }

}
