package xeredi.integra.model.facturacion.vo;

import java.util.Date;
import java.util.Set;

import xeredi.integra.model.comun.vo.BaseCriterioVO;
import xeredi.integra.model.comun.vo.Typeahead;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoCriterioVO.
 */
public final class CargoCriterioVO extends BaseCriterioVO implements Typeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

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

    /** The codigo. */
    private String codigo;

    /** The codigo normalizado. */
    private String codigoNormalizado;

    /** The tpsr id. */
    private Long tpsrId;

    /** The srvc id. */
    private Long srvcId;

    /** The aspc id. */
    private Long aspcId;

    /** The vlrc id. */
    private Long vlrcId;

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
     * Gets the codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     *
     * @param value
     *            the new codigo
     */
    public void setCodigo(final String value) {
        codigo = value;
    }

    /**
     * Gets the codigo normalizado.
     *
     * @return the codigo normalizado
     */
    public String getCodigoNormalizado() {
        return codigoNormalizado;
    }

    /**
     * Sets the codigo normalizado.
     *
     * @param value
     *            the new codigo normalizado
     */
    public void setCodigoNormalizado(final String value) {
        codigoNormalizado = value;
    }

    /**
     * Gets the tpsr id.
     *
     * @return the tpsr id
     */
    public Long getTpsrId() {
        return tpsrId;
    }

    /**
     * Sets the tpsr id.
     *
     * @param value
     *            the new tpsr id
     */
    public void setTpsrId(final Long value) {
        tpsrId = value;
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
     *            the new vlrc id
     */
    public void setVlrcId(final Long value) {
        vlrcId = value;
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
     * {@inheritDoc}
     */
    @Override
    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTextoBusqueda(final String value) {
        textoBusqueda = value;
    }
}
