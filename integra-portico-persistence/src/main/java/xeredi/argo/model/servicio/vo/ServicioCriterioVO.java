package xeredi.argo.model.servicio.vo;

import java.util.Date;

import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.item.vo.ItemCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioCriterioVO.
 */
public final class ServicioCriterioVO extends ItemCriterioVO {

    /** The subp id. */
    private PuertoCriterioVO prto;

    /** The anno. */
    private String anno;

    /** The numero. */
    private String numero;

    /** The estado. */
    private String estado;

    /** The fref min. */
    private Date frefMin;

    /** The fref max. */
    private Date frefMax;

    /** The fini min. */
    private Date finiMin;

    /** The fini max. */
    private Date finiMax;

    /** The ffin min. */
    private Date ffinMin;

    /** The ffin max. */
    private Date ffinMax;

    /**
     * Gets the prto.
     *
     * @return the prto
     */
    public PuertoCriterioVO getPrto() {
        return prto;
    }

    /**
     * Sets the prto.
     *
     * @param value
     *            the new prto
     */
    public void setPrto(final PuertoCriterioVO value) {
        prto = value;
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

    /**
     * Gets the fref min.
     *
     * @return the fref min
     */
    public Date getFrefMin() {
        return frefMin;
    }

    /**
     * Sets the fref min.
     *
     * @param value
     *            the new fref min
     */
    public void setFrefMin(final Date value) {
        frefMin = value;
    }

    /**
     * Gets the fref max.
     *
     * @return the fref max
     */
    public Date getFrefMax() {
        return frefMax;
    }

    /**
     * Sets the fref max.
     *
     * @param value
     *            the new fref max
     */
    public void setFrefMax(final Date value) {
        frefMax = value;
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
