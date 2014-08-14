package xeredi.integra.model.vo.facturacion;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.integra.model.vo.servicio.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionVO.
 */
public final class ValoracionVO {

    /** The id. */
    private Long id;

    /** The srvc. */
    private ServicioVO srvc;

    /** The aspc. */
    private AspectoVO aspc;

    /** The pagador. */
    private ParametroVO pagador;

    /** The fref. */
    private Date fref;

    /** The falta. */
    private Date falta;

    /** The fliq. */
    private Date fliq;

    /** The fini. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The importe. */
    private Double importe;

    /** The iva. */
    private Double impuesto;

    /** The suj pasivo. */
    private Boolean sujPasivo;

    /** The cod exencion. */
    private String codExencion;

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
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the srvc.
     *
     * @return the srvc
     */
    public ServicioVO getSrvc() {
        return srvc;
    }

    /**
     * Sets the srvc.
     *
     * @param value
     *            the srvc
     */
    public void setSrvc(ServicioVO value) {
        this.srvc = value;
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
     *            the aspc
     */
    public void setAspc(AspectoVO value) {
        this.aspc = value;
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
     *            the pagador
     */
    public void setPagador(ParametroVO value) {
        this.pagador = value;
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
     *            the fref
     */
    public void setFref(Date value) {
        this.fref = value;
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
     *            the falta
     */
    public void setFalta(Date value) {
        this.falta = value;
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
     *            the fini
     */
    public void setFini(Date value) {
        this.fini = value;
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
     *            the ffin
     */
    public void setFfin(Date value) {
        this.ffin = value;
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
    public void setImporte(Double value) {
        this.importe = value;
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
     *            the suj pasivo
     */
    public void setSujPasivo(Boolean value) {
        this.sujPasivo = value;
    }

    /**
     * Gets the cod exencion.
     *
     * @return the cod exencion
     */
    public String getCodExencion() {
        return codExencion;
    }

    /**
     * Sets the cod exencion.
     *
     * @param value
     *            the cod exencion
     */
    public void setCodExencion(String value) {
        this.codExencion = value;
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
     *            the info1
     */
    public void setInfo1(String value) {
        this.info1 = value;
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
     *            the info2
     */
    public void setInfo2(String value) {
        this.info2 = value;
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
     *            the info3
     */
    public void setInfo3(String value) {
        this.info3 = value;
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
     *            the info4
     */
    public void setInfo4(String value) {
        this.info4 = value;
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
     *            the info5
     */
    public void setInfo5(String value) {
        this.info5 = value;
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
     *            the info6
     */
    public void setInfo6(String value) {
        this.info6 = value;
    }

    /**
     * Gets the fliq.
     *
     * @return the fliq
     */
    public Date getFliq() {
        return fliq;
    }

    /**
     * Sets the fliq.
     *
     * @param value
     *            the new fliq
     */
    public void setFliq(Date value) {
        this.fliq = value;
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
     *            the new impuesto
     */
    public void setImpuesto(Double value) {
        this.impuesto = value;
    }

}
