package xeredi.integra.model.servicio.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaVO.
 */
public final class ServicioSecuenciaVO {

    /** The tpsr id. */
    private Long tpsrId;

    /** The subp id. */
    private Long subpId;

    /** The anno. */
    private Integer anno;

    /** The ultimo numero. */
    private Integer ultimoNumero;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     * Gets the subp id.
     * 
     * @return the subp id
     */
    public Long getSubpId() {
        return subpId;
    }

    /**
     * Sets the subp id.
     * 
     * @param value
     *            the new subp id
     */
    public void setSubpId(final Long value) {
        subpId = value;
    }

    /**
     * Gets the anno.
     * 
     * @return the anno
     */
    public Integer getAnno() {
        return anno;
    }

    /**
     * Sets the anno.
     * 
     * @param value
     *            the new anno
     */
    public void setAnno(final Integer value) {
        anno = value;
    }

    /**
     * Gets the ultimo numero.
     * 
     * @return the ultimo numero
     */
    public Integer getUltimoNumero() {
        return ultimoNumero;
    }

    /**
     * Sets the ultimo numero.
     * 
     * @param value
     *            the new ultimo numero
     */
    public void setUltimoNumero(final Integer value) {
        ultimoNumero = value;
    }

}
