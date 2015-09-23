package xeredi.argo.model.facturacion.vo;

import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaServicioCriterioVO.
 */
public final class FacturaServicioCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The fctr id. */
    private Long fctrId;

    /** The srvc id. */
    private Long srvcId;

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
     * Gets the fctr id.
     *
     * @return the fctr id
     */
    public final Long getFctrId() {
        return fctrId;
    }

    /**
     * Sets the fctr id.
     *
     * @param value
     *            the new fctr id
     */
    public final void setFctrId(final Long value) {
        fctrId = value;
    }

}