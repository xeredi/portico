package xeredi.integra.model.facturacion.vo;

import xeredi.integra.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleCriterioVO.
 */
public final class ValoracionDetalleCriterioVO extends BaseCriterioVO {

    /** The vlrl. */
    private ValoracionLineaCriterioVO vlrl;

    /** The id. */
    private Long id;

    /**
     * Gets the vlrl.
     *
     * @return the vlrl
     */
    public ValoracionLineaCriterioVO getVlrl() {
        return vlrl;
    }

    /**
     * Sets the vlrl.
     *
     * @param value
     *            the vlrl
     */
    public void setVlrl(final ValoracionLineaCriterioVO value) {
        vlrl = value;
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

}
