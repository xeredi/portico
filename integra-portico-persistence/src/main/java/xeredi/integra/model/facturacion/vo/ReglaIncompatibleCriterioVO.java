package xeredi.integra.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleCriterioVO.
 */
public final class ReglaIncompatibleCriterioVO {

    /** The id. */
    private Long id;

    /** The rgiv id. */
    private Long rgivId;

    /** The rgla1 id. */
    private Long rgla1Id;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     * Gets the rgla1 id.
     *
     * @return the rgla1 id
     */
    public Long getRgla1Id() {
        return rgla1Id;
    }

    /**
     * Sets the rgla1 id.
     *
     * @param value
     *            the new rgla1 id
     */
    public void setRgla1Id(final Long value) {
        rgla1Id = value;
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
     * Gets the rgiv id.
     *
     * @return the rgiv id
     */
    public Long getRgivId() {
        return rgivId;
    }

    /**
     * Sets the rgiv id.
     *
     * @param value
     *            the new rgiv id
     */
    public void setRgivId(final Long value) {
        rgivId = value;
    }

}
