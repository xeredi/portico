package xeredi.integra.model.facturacion.vo;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaCriterioVO.
 */
public final class ReglaCriterioVO {

    /** The fecha referencia. */
    private Date fechaVigencia;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The incompatible id. */
    private Long incompatibleId;

    /** The rglv id. */
    private Long rglvId;

    /** The tipo. */
    private ReglaTipo tipo;

    /** The crgo id. */
    private Long crgoId;

    /** The crgv id. */
    private Long crgvId;

    /** The vlrc id. */
    private Long vlrcId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the fecha referencia.
     *
     * @return the fecha referencia
     */
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha referencia.
     *
     * @param value
     *            the fecha referencia
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
     *            the id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the ids.
     *
     * @return the ids
     */
    public Set<Long> getIds() {
        return ids;
    }

    /**
     * Sets the ids.
     *
     * @param value
     *            the ids
     */
    public void setIds(final Set<Long> value) {
        ids = value;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public ReglaTipo getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param value
     *            the tipo
     */
    public void setTipo(final ReglaTipo value) {
        tipo = value;
    }

    /**
     * Gets the crgo id.
     *
     * @return the crgo id
     */
    public Long getCrgoId() {
        return crgoId;
    }

    /**
     * Sets the crgo id.
     *
     * @param value
     *            the crgo id
     */
    public void setCrgoId(final Long value) {
        crgoId = value;
    }

    /**
     * Gets the rglv id.
     *
     * @return the rglv id
     */
    public Long getRglvId() {
        return rglvId;
    }

    /**
     * Sets the rglv id.
     *
     * @param value
     *            the new rglv id
     */
    public void setRglvId(final Long value) {
        rglvId = value;
    }

    /**
     * Gets the incompatible id.
     *
     * @return the incompatible id
     */
    public Long getIncompatibleId() {
        return incompatibleId;
    }

    /**
     * Sets the incompatible id.
     *
     * @param value
     *            the new incompatible id
     */
    public void setIncompatibleId(final Long value) {
        incompatibleId = value;
    }

    /**
     * Gets the vlrc id.
     *
     * @return the vlrc id
     */
    public Long getVlrcId() {
        return vlrcId;
    }

    /**
     * Sets the vlrc id.
     *
     * @param value
     *            the vlrc id
     */
    public void setVlrcId(final Long value) {
        vlrcId = value;
    }

    /**
     * Gets the crgv id.
     *
     * @return the crgv id
     */
    public Long getCrgvId() {
        return crgvId;
    }

    /**
     * Sets the crgv id.
     *
     * @param value
     *            the new crgv id
     */
    public void setCrgvId(final Long value) {
        crgvId = value;
    }

}
