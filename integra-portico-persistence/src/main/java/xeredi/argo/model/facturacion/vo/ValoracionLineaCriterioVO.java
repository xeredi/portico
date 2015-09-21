package xeredi.argo.model.facturacion.vo;

import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaCriterioVO.
 */
public final class ValoracionLineaCriterioVO extends BaseCriterioVO {

    /** The vlrc. */
    private ValoracionCriterioVO vlrc;

    /** The id. */
    private Long id;

    /** The padre id. */
    private Long padreId;

    /** The solo hijos. */
    private boolean soloHijos;

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
     * Checks if is solo hijos.
     *
     * @return true, if is solo hijos
     */
    public boolean isSoloHijos() {
        return soloHijos;
    }

    /**
     * Sets the solo hijos.
     *
     * @param value
     *            the new solo hijos
     */
    public void setSoloHijos(final boolean value) {
        soloHijos = value;
    }

}
