package xeredi.integra.model.facturacion.vo;

import xeredi.integra.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaCriterioVO.
 */
public final class ValoracionLineaCriterioVO extends BaseCriterioVO {

    /** The vlrc. */
    private ValoracionCriterioVO vlrc;

    /** The id. */
    private Long id;

    /**
     * Gets the vlrc.
     *
     * @return the vlrc
     */
    public ValoracionCriterioVO getVlrc() {
        return vlrc;
    }

    /**
     * Sets the vlrc.
     *
     * @param value
     *            the vlrc
     */
    public void setVlrc(final ValoracionCriterioVO value) {
        vlrc = value;
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
