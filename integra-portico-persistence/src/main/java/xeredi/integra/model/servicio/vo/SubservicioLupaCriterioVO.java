package xeredi.integra.model.servicio.vo;

import xeredi.integra.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioLupaCriterioVO.
 */
public final class SubservicioLupaCriterioVO extends BaseCriterioVO {
    /** The enti id. */
    private Long entiId;

    /** The texto busqueda. */
    private Integer numero;

    /** The srvc id. */
    private Long srvcId;

    /**
     * Gets the enti id.
     *
     * @return the enti id
     */
    public Long getEntiId() {
        return entiId;
    }

    /**
     * Sets the enti id.
     *
     * @param value
     *            the new enti id
     */
    public void setEntiId(final Long value) {
        entiId = value;
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

}
