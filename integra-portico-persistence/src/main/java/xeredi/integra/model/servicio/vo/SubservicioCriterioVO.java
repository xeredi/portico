package xeredi.integra.model.servicio.vo;

import java.util.Set;

import xeredi.integra.model.comun.vo.ItemCriterioVO;

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

}
