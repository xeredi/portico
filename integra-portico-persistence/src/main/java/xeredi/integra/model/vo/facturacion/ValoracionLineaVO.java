package xeredi.integra.model.vo.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.integra.model.vo.servicio.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaVO.
 */
public final class ValoracionLineaVO {

    /** The id. */
    private Long id;

    /** The vlrc id. */
    private Long vlrcId;

    /** The crgo. */
    private CargoVO crgo;

    /** The rgla. */
    private ReglaVO rgla;

    /** The orden. */
    private Integer orden;

    /** The importe base. */
    private Double importeBase;

    /** The importe. */
    private Double importe;

    /** The impuesto. */
    private ParametroVO impuesto;

    /** The ssrv. */
    private SubservicioVO ssrv;

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
     *            the vlrc id
     */
    public void setVlrcId(Long value) {
        this.vlrcId = value;
    }

    /**
     * Gets the crgo.
     *
     * @return the crgo
     */
    public CargoVO getCrgo() {
        return crgo;
    }

    /**
     * Sets the crgo.
     *
     * @param value
     *            the crgo
     */
    public void setCrgo(CargoVO value) {
        this.crgo = value;
    }

    /**
     * Gets the rgla.
     *
     * @return the rgla
     */
    public ReglaVO getRgla() {
        return rgla;
    }

    /**
     * Sets the rgla.
     *
     * @param value
     *            the rgla
     */
    public void setRgla(ReglaVO value) {
        this.rgla = value;
    }

    /**
     * Gets the orden.
     *
     * @return the orden
     */
    public Integer getOrden() {
        return orden;
    }

    /**
     * Sets the orden.
     *
     * @param value
     *            the orden
     */
    public void setOrden(Integer value) {
        this.orden = value;
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
     *            the importe base
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
     *            the importe
     */
    public void setImporte(Double value) {
        this.importe = value;
    }

    /**
     * Gets the impuesto.
     *
     * @return the impuesto
     */
    public ParametroVO getImpuesto() {
        return impuesto;
    }

    /**
     * Sets the impuesto.
     *
     * @param value
     *            the impuesto
     */
    public void setImpuesto(ParametroVO value) {
        this.impuesto = value;
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
     *            the ssrv
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
     *            the cuant1
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
     *            the cuant2
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
     *            the cuant3
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
     *            the cuant4
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
     *            the cuant5
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
     *            the cuant6
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

}
