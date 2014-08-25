package xeredi.integra.model.facturacion.vo;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoCriterioVO.
 */
public final class CargoCriterioVO {

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The crgv id. */
    private Long crgvId;

    /** The padre id. */
    private Long padreId;

    /** The padre ids. */
    private Set<Long> padreIds;

    /** The solo principales. */
    private boolean soloPrincipales;

    /** The solo dependientes. */
    private boolean soloDependientes;

    /** The srvc id. */
    private Long srvcId;

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
     *            the fecha vigencia
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
     * Gets the padre id.
     *
     * @return the padre id
     */
    public Long getPadreId() {
        return padreId;
    }

    /**
     * Sets the padre id.
     *
     * @param value
     *            the padre id
     */
    public void setPadreId(final Long value) {
        padreId = value;
    }

    /**
     * Gets the padre ids.
     *
     * @return the padre ids
     */
    public Set<Long> getPadreIds() {
        return padreIds;
    }

    /**
     * Sets the padre ids.
     *
     * @param value
     *            the padre ids
     */
    public void setPadreIds(final Set<Long> value) {
        padreIds = value;
    }

    /**
     * Checks if is solo principales.
     *
     * @return true, if checks if is solo principales
     */
    public boolean isSoloPrincipales() {
        return soloPrincipales;
    }

    /**
     * Sets the solo principales.
     *
     * @param value
     *            the solo principales
     */
    public void setSoloPrincipales(final boolean value) {
        soloPrincipales = value;
    }

    /**
     * Checks if is solo dependientes.
     *
     * @return true, if checks if is solo dependientes
     */
    public boolean isSoloDependientes() {
        return soloDependientes;
    }

    /**
     * Sets the solo dependientes.
     *
     * @param value
     *            the solo dependientes
     */
    public void setSoloDependientes(final boolean value) {
        soloDependientes = value;
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
     *            the srvc id
     */
    public void setSrvcId(final Long value) {
        srvcId = value;
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
