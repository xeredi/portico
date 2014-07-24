package xeredi.integra.model.vo.facturacion;

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
    public void setFechaVigencia(Date value) {
        this.fechaVigencia = value;
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
    public void setId(Long value) {
        this.id = value;
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
    public void setIds(Set<Long> value) {
        this.ids = value;
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
    public void setPadreId(Long value) {
        this.padreId = value;
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
    public void setPadreIds(Set<Long> value) {
        this.padreIds = value;
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
    public void setSoloPrincipales(boolean value) {
        this.soloPrincipales = value;
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
    public void setSoloDependientes(boolean value) {
        this.soloDependientes = value;
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
    public void setSrvcId(Long value) {
        this.srvcId = value;
    }

}
