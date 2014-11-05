package xeredi.integra.model.servicio.vo;

import xeredi.integra.model.comun.vo.ItemCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioCriterioVO.
 */
public final class ServicioCriterioVO extends ItemCriterioVO {

    /** The subp id. */
    private ParametroVO subp;

    /** The anno. */
    private String anno;

    /** The numero. */
    private String numero;

    /** The estado. */
    private String estado;

    /**
     * Gets the subp.
     *
     * @return the subp
     */
    public ParametroVO getSubp() {
        return subp;
    }

    /**
     * Sets the subp.
     *
     * @param value
     *            the new subp
     */
    public void setSubp(final ParametroVO value) {
        subp = value;
    }

    /**
     * Gets the anno.
     *
     * @return the anno
     */
    public String getAnno() {
        return anno;
    }

    /**
     * Sets the anno.
     *
     * @param value
     *            the new anno
     */
    public void setAnno(final String value) {
        anno = value;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param value
     *            the new numero
     */
    public void setNumero(final String value) {
        numero = value;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param value
     *            the new estado
     */
    public void setEstado(final String value) {
        estado = value;
    }

}
