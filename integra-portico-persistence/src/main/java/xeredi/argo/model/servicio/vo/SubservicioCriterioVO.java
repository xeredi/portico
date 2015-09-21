package xeredi.argo.model.servicio.vo;

import java.util.Date;
import java.util.Set;

import xeredi.argo.model.item.vo.ItemCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioCriterioVO.
 */
public final class SubservicioCriterioVO extends ItemCriterioVO {

    /** The padre id. */
    private Long padreId;

    /** The padre ids. */
    private Set<Long> padreIds;

    /** The hijo id. */
    private Long hijoId;

    /** The hijo ids. */
    private Set<Long> hijoIds;

    /** The numero. */
    private Integer numero;

    /** The estado. */
    private String estado;

    /** The fini min. */
    private Date finiMin;

    /** The fini max. */
    private Date finiMax;

    /** The ffin min. */
    private Date ffinMin;

    /** The ffin max. */
    private Date ffinMax;

    /** The srvc. */
    private ServicioCriterioVO srvc;

    /**
     * Gets the srvc.
     *
     * @return the srvc
     */
    public ServicioCriterioVO getSrvc() {
        return srvc;
    }

    /**
     * Sets the srvc.
     *
     * @param value
     *            the new srvc
     */
    public void setSrvc(final ServicioCriterioVO value) {
        srvc = value;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param value
     *            the new numero
     */
    public void setNumero(final Integer value) {
        numero = value;
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
     *            the new padre id
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
     *            the new padre ids
     */
    public void setPadreIds(final Set<Long> value) {
        padreIds = value;
    }

    /**
     * Gets the hijo id.
     *
     * @return the hijo id
     */
    public Long getHijoId() {
        return hijoId;
    }

    /**
     * Sets the hijo id.
     *
     * @param value
     *            the new hijo id
     */
    public void setHijoId(final Long value) {
        hijoId = value;
    }

    /**
     * Gets the hijo ids.
     *
     * @return the hijo ids
     */
    public Set<Long> getHijoIds() {
        return hijoIds;
    }

    /**
     * Sets the hijo ids.
     *
     * @param value
     *            the new hijo ids
     */
    public void setHijoIds(final Set<Long> value) {
        hijoIds = value;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public final String getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param value
     *            the new estado
     */
    public final void setEstado(final String value) {
        estado = value;
    }

    /**
     * Gets the fini min.
     *
     * @return the fini min
     */
    public Date getFiniMin() {
        return finiMin;
    }

    /**
     * Sets the fini min.
     *
     * @param value
     *            the new fini min
     */
    public void setFiniMin(final Date value) {
        finiMin = value;
    }

    /**
     * Gets the fini max.
     *
     * @return the fini max
     */
    public Date getFiniMax() {
        return finiMax;
    }

    /**
     * Sets the fini max.
     *
     * @param value
     *            the new fini max
     */
    public void setFiniMax(final Date value) {
        finiMax = value;
    }

    /**
     * Gets the ffin min.
     *
     * @return the ffin min
     */
    public Date getFfinMin() {
        return ffinMin;
    }

    /**
     * Sets the ffin min.
     *
     * @param value
     *            the new ffin min
     */
    public void setFfinMin(final Date value) {
        ffinMin = value;
    }

    /**
     * Gets the ffin max.
     *
     * @return the ffin max
     */
    public Date getFfinMax() {
        return ffinMax;
    }

    /**
     * Sets the ffin max.
     *
     * @param value
     *            the new ffin max
     */
    public void setFfinMax(final Date value) {
        ffinMax = value;
    }
}
