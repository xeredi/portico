package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaVO.
 */
public final class FacturaVO {

    /** The Constant NUMERO_LENGTH. */
    private static final int NUMERO_LENGTH = 5;

    /** The id. */
    private Long id;

    /** The aspc. */
    private AspectoVO aspc;

    /** The pagador. */
    private ParametroVO pagador;

    /** The fcsr. */
    private FacturaSerieVO fcsr;

    /** The numero. */
    private Integer numero;

    /** The falta. */
    private Date falta;

    /** The fref. */
    private Date fref;

    /** The fini. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The estado. */
    private FacturaEstado estado;

    /** The suj pasivo. */
    private Boolean sujPasivo;

    /** The importe. */
    private Double importe;

    /** The impuesto. */
    private Double impuesto;

    /** The info1. */
    private String info1;

    /** The info2. */
    private String info2;

    /** The info3. */
    private String info3;

    /** The info4. */
    private String info4;

    /** The info5. */
    private String info5;

    /** The info6. */
    private String info6;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        final StringBuilder etiqueta = new StringBuilder();

        if (fcsr != null) {
            etiqueta.append(fcsr.getSerie()).append('/').append(fcsr.getAnio()).append('/');
        }

        etiqueta.append(StringUtils.leftPad(String.valueOf(numero), NUMERO_LENGTH, '0'));

        return etiqueta.toString();
    }

    /**
     * Gets the fcsr.
     *
     * @return the fcsr
     */
    public FacturaSerieVO getFcsr() {
        return fcsr;
    }

    /**
     * Sets the fcsr.
     *
     * @param value
     *            the fcsr
     */
    public void setFcsr(final FacturaSerieVO value) {
        fcsr = value;
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
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
    }

    /**
     * Sets the aspc.
     *
     * @param value
     *            the new aspc
     */
    public void setAspc(final AspectoVO value) {
        aspc = value;
    }

    /**
     * Gets the pagador.
     *
     * @return the pagador
     */
    public ParametroVO getPagador() {
        return pagador;
    }

    /**
     * Sets the pagador.
     *
     * @param value
     *            the new pagador
     */
    public void setPagador(final ParametroVO value) {
        pagador = value;
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
     * Gets the fref.
     *
     * @return the fref
     */
    public Date getFref() {
        return fref;
    }

    /**
     * Sets the fref.
     *
     * @param value
     *            the new fref
     */
    public void setFref(final Date value) {
        fref = value;
    }

    /**
     * Gets the fini.
     *
     * @return the fini
     */
    public Date getFini() {
        return fini;
    }

    /**
     * Sets the fini.
     *
     * @param value
     *            the new fini
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
     * Gets the info1.
     *
     * @return the info1
     */
    public String getInfo1() {
        return info1;
    }

    /**
     * Sets the info1.
     *
     * @param value
     *            the new info1
     */
    public void setInfo1(final String value) {
        info1 = value;
    }

    /**
     * Gets the info2.
     *
     * @return the info2
     */
    public String getInfo2() {
        return info2;
    }

    /**
     * Sets the info2.
     *
     * @param value
     *            the new info2
     */
    public void setInfo2(final String value) {
        info2 = value;
    }

    /**
     * Gets the info3.
     *
     * @return the info3
     */
    public String getInfo3() {
        return info3;
    }

    /**
     * Sets the info3.
     *
     * @param value
     *            the new info3
     */
    public void setInfo3(final String value) {
        info3 = value;
    }

    /**
     * Gets the info4.
     *
     * @return the info4
     */
    public String getInfo4() {
        return info4;
    }

    /**
     * Sets the info4.
     *
     * @param value
     *            the new info4
     */
    public void setInfo4(final String value) {
        info4 = value;
    }

    /**
     * Gets the info5.
     *
     * @return the info5
     */
    public String getInfo5() {
        return info5;
    }

    /**
     * Sets the info5.
     *
     * @param value
     *            the new info5
     */
    public void setInfo5(final String value) {
        info5 = value;
    }

    /**
     * Gets the info6.
     *
     * @return the info6
     */
    public String getInfo6() {
        return info6;
    }

    /**
     * Sets the info6.
     *
     * @param value
     *            the new info6
     */
    public void setInfo6(final String value) {
        info6 = value;
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
     *            the numero
     */
    public void setNumero(final Integer value) {
        numero = value;
    }

    /**
     * Gets the importe.
     *
     * @return the importe
     */
    public Double getImporte() {
        return importe;
    }

    /**
     * Sets the importe.
     *
     * @param value
     *            the importe
     */
    public void setImporte(final Double value) {
        importe = value;
    }

    /**
     * Gets the impuesto.
     *
     * @return the impuesto
     */
    public Double getImpuesto() {
        return impuesto;
    }

    /**
     * Sets the impuesto.
     *
     * @param value
     *            the impuesto
     */
    public void setImpuesto(final Double value) {
        impuesto = value;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public FacturaEstado getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param value
     *            the estado
     */
    public void setEstado(final FacturaEstado value) {
        estado = value;
    }

    /**
     * Gets the suj pasivo.
     *
     * @return the suj pasivo
     */
    public Boolean getSujPasivo() {
        return sujPasivo;
    }

    /**
     * Sets the suj pasivo.
     *
     * @param value
     *            the new suj pasivo
     */
    public void setSujPasivo(final Boolean value) {
        sujPasivo = value;
    }

}
