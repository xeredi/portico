package xeredi.argo.model.servicio.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaVO.
 */
public final class ServicioSecuenciaVO {

    /** The tpsr id. */
    private TipoServicioVO tpsr;

    /** The subp id. */
    private PuertoVO prto;

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

    /**
     * Gets the tpsr.
     *
     * @return the tpsr
     */
    public TipoServicioVO getTpsr() {
        return tpsr;
    }

    /**
     * Sets the tpsr.
     *
     * @param value
     *            the new tpsr
     */
    public void setTpsr(final TipoServicioVO value) {
        tpsr = value;
    }

    /**
     * Gets the prto.
     *
     * @return the prto
     */
    public PuertoVO getPrto() {
        return prto;
    }

    /**
     * Sets the prto.
     *
     * @param value
     *            the new prto
     */
    public void setPrto(final PuertoVO value) {
        prto = value;
    }

}
