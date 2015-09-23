package xeredi.argo.model.servicio.vo;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioVO.
 */
public final class ServicioVO extends ItemVO {

    /** The Constant NUMERO_LENGTH. */
    public static final int NUMERO_LENGTH = 5;

    /** The subpuerto. */
    private PuertoVO prto;

    /** The anno. */
    private String anno;

    /** The numero. */
    private String numero;

    /** The falta. */
    private Date falta;

    /** The fbaja. */
    private Date fbaja;

    /** The finicio. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The estado. */
    private String estado;

    /**
     * Instantiates a new servicio vo.
     */
    public ServicioVO() {
        super();
    }

    /**
     * Instantiates a new servicio vo.
     *
     * @param entiDetail
     *            the enti detail
     */
    public ServicioVO(final TipoServicioDetailVO entiDetail) {
        super(entiDetail);

        estado = entiDetail.getEnti().getEstadoDef();
    }

    /**
     * Convert numero.
     *
     * @param numero
     *            the numero
     * @return the string
     */
    public static final String convertNumero(final Integer numero) {
        return StringUtils.leftPad(String.valueOf(numero), NUMERO_LENGTH, '0');
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEtiqueta() {
        if ((prto == null || prto.getCodigo() == null) && anno == null && numero == null) {
            return null;
        }

        final StringBuffer buffer = new StringBuffer();

        buffer.append(prto == null ? "-" : prto.getCodigo()).append('/').append(anno).append('/').append(numero);

        return buffer.toString();
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
     * Gets the falta.
     *
     * @return the falta
     */
    public Date getFalta() {
        return falta;
    }

    /**
     * Sets the falta.
     *
     * @param value
     *            the new falta
     */
    public void setFalta(final Date value) {
        falta = value;
    }

    /**
     * Gets the fbaja.
     *
     * @return the fbaja
     */
    public Date getFbaja() {
        return fbaja;
    }

    /**
     * Sets the fbaja.
     *
     * @param value
     *            the new fbaja
     */
    public void setFbaja(final Date value) {
        fbaja = value;
    }

    /**
     * Gets the finicio.
     *
     * @return the finicio
     */
    public Date getFini() {
        return fini;
    }

    /**
     * Sets the finicio.
     *
     * @param value
     *            the new finicio
     */
    public void setFini(final Date value) {
        fini = value;
    }

    /**
     * Gets the ffin.
     *
     * @return the ffin
     */
    public Date getFfin() {
        return ffin;
    }

    /**
     * Sets the ffin.
     *
     * @param value
     *            the new ffin
     */
    public void setFfin(final Date value) {
        ffin = value;
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