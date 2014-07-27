package xeredi.integra.model.vo.servicio;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.comun.ItemVO;
import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.integra.model.vo.metamodelo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioVO.
 */
public final class ServicioVO extends ItemVO {

    /** The Constant NUMERO_LENGTH. */
    public static final int NUMERO_LENGTH = 5;

    /** The subpuerto. */
    private ParametroVO subp;

    /** The anno. */
    private String anno;

    /** The numero. */
    private String numero;

    /** The falta. */
    private Date falta;

    /** The fbaja. */
    private Date fbaja;

    /** The freferencia. */
    private Date freferencia;

    /** The finicio. */
    private Date finicio;

    /** The ffin. */
    private Date ffin;

    /** The estado. */
    private String estado;

    /**
     * Instancia un nuevo {@link ServicioVO} con todos sus datos asociados.
     *
     * @param tpsrVO
     *            Tipo de Servicio del que se quiere instanciar un servicio.
     * @return Servicio creado.
     */
    public static ServicioVO newInstance(final TipoServicioVO tpsrVO) {
        final ServicioVO srvcVO = new ServicioVO();

        srvcVO.setEntiId(tpsrVO.getId());

        if (tpsrVO.getEntdList() != null && !tpsrVO.getEntdList().isEmpty()) {
            final HashMap<Long, ItemDatoVO> itdtMap = new HashMap<>();

            for (final Long tpdtId : tpsrVO.getEntdList()) {
                final ItemDatoVO itdtVO = new ItemDatoVO();

                itdtVO.setTpdtId(tpdtId);
                itdtMap.put(itdtVO.getTpdtId(), itdtVO);
            }

            srvcVO.setItdtMap(itdtMap);
        }

        return srvcVO;
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
        final StringBuffer buffer = new StringBuffer();

        buffer.append(subp == null ? "-" : subp.getParametro()).append('/').append(anno).append('/').append(numero);

        return buffer.toString();
    }

    /**
     * Gets the subpuerto.
     *
     * @return the subpuerto
     */
    public ParametroVO getSubp() {
        return subp;
    }

    /**
     * Sets the subpuerto.
     *
     * @param value
     *            the new subpuerto
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
     * Gets the freferencia.
     *
     * @return the freferencia
     */
    public Date getFreferencia() {
        return freferencia;
    }

    /**
     * Sets the freferencia.
     *
     * @param value
     *            the new freferencia
     */
    public void setFreferencia(final Date value) {
        freferencia = value;
    }

    /**
     * Gets the finicio.
     *
     * @return the finicio
     */
    public Date getFinicio() {
        return finicio;
    }

    /**
     * Sets the finicio.
     *
     * @param value
     *            the new finicio
     */
    public void setFinicio(final Date value) {
        finicio = value;
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
