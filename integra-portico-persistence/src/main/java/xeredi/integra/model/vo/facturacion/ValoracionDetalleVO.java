package xeredi.integra.model.vo.facturacion;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.vo.servicio.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleVO.
 */
public final class ValoracionDetalleVO {

    /** The id. */
    private Long id;

    /** The vlrc id. */
    private Long vlrcId;

    /** The vlrl id. */
    private Long vlrlId;

    /** The importe base. */
    private Double importeBase;

    /** The importe. */
    private Double importe;

    /** The ssrv. */
    private SubservicioVO ssrv;

    /** The fini. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The cuant1. */
    private Double cuant1;

    /** The cuant2. */
    private Double cuant2;

    /** The cuant3. */
    private Double cuant3;

    /** The cuant4. */
    private Double cuant4;

    /** The cuant5. */
    private Double cuant5;

    /** The cuant6. */
    private Double cuant6;

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
     * Gets the vlrc id.
     *
     * @return the vlrc id
     */
    public Long getVlrcId() {
        return vlrcId;
    }

    /**
     * Sets the vlrc id.
     *
     * @param value
     *            the new vlrc id
     */
    public void setVlrcId(Long value) {
        this.vlrcId = value;
    }

    /**
     * Gets the vlrl id.
     *
     * @return the vlrl id
     */
    public Long getVlrlId() {
        return vlrlId;
    }

    /**
     * Sets the vlrl id.
     *
     * @param value
     *            the new vlrl id
     */
    public void setVlrlId(Long value) {
        this.vlrlId = value;
    }

    /**
     * Gets the importe base.
     *
     * @return the importe base
     */
    public Double getImporteBase() {
        return importeBase;
    }

    /**
     * Sets the importe base.
     *
     * @param value
     *            the new importe base
     */
    public void setImporteBase(Double value) {
        this.importeBase = value;
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
     *            the new importe
     */
    public void setImporte(Double value) {
        this.importe = value;
    }

    /**
     * Gets the ssrv.
     *
     * @return the ssrv
     */
    public SubservicioVO getSsrv() {
        return ssrv;
    }

    /**
     * Sets the ssrv.
     *
     * @param value
     *            the new ssrv
     */
    public void setSsrv(SubservicioVO value) {
        this.ssrv = value;
    }

    /**
     * Gets the cuant1.
     *
     * @return the cuant1
     */
    public Double getCuant1() {
        return cuant1;
    }

    /**
     * Sets the cuant1.
     *
     * @param value
     *            the new cuant1
     */
    public void setCuant1(Double value) {
        this.cuant1 = value;
    }

    /**
     * Gets the cuant2.
     *
     * @return the cuant2
     */
    public Double getCuant2() {
        return cuant2;
    }

    /**
     * Sets the cuant2.
     *
     * @param value
     *            the new cuant2
     */
    public void setCuant2(Double value) {
        this.cuant2 = value;
    }

    /**
     * Gets the cuant3.
     *
     * @return the cuant3
     */
    public Double getCuant3() {
        return cuant3;
    }

    /**
     * Sets the cuant3.
     *
     * @param value
     *            the new cuant3
     */
    public void setCuant3(Double value) {
        this.cuant3 = value;
    }

    /**
     * Gets the cuant4.
     *
     * @return the cuant4
     */
    public Double getCuant4() {
        return cuant4;
    }

    /**
     * Sets the cuant4.
     *
     * @param value
     *            the new cuant4
     */
    public void setCuant4(Double value) {
        this.cuant4 = value;
    }

    /**
     * Gets the cuant5.
     *
     * @return the cuant5
     */
    public Double getCuant5() {
        return cuant5;
    }

    /**
     * Sets the cuant5.
     *
     * @param value
     *            the new cuant5
     */
    public void setCuant5(Double value) {
        this.cuant5 = value;
    }

    /**
     * Gets the cuant6.
     *
     * @return the cuant6
     */
    public Double getCuant6() {
        return cuant6;
    }

    /**
     * Sets the cuant6.
     *
     * @param value
     *            the new cuant6
     */
    public void setCuant6(Double value) {
        this.cuant6 = value;
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
     *            the new info2
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
     *            the new info3
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
     *            the new info4
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
     *            the new info5
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
     *            the new info6
     */
    public void setInfo6(String value) {
        this.info6 = value;
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

}
