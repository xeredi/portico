package xeredi.argo.model.estadistica.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesVO.
 */
public final class CuadroMesVO {

    /** The id. */
    private Long id;

    /** The pepr id. */
    private Long peprId;

    /** The prto. */
    private PuertoVO prto;

    /** The cocu. */
    private String cocu;

    /** The opet. */
    private String opet;

    /** The navt. */
    private ParametroVO navt;

    /** The pais. */
    private ParametroVO pais;

    /** The cantidad. */
    private Double cantidad;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the pepr id.
     *
     * @return the pepr id
     */
    public Long getPeprId() {
        return peprId;
    }

    /**
     * Sets the pepr id.
     *
     * @param value
     *            the new pepr id
     */
    public void setPeprId(final Long value) {
        peprId = value;
    }

    /**
     * Gets the cocu.
     *
     * @return the cocu
     */
    public String getCocu() {
        return cocu;
    }

    /**
     * Sets the cocu.
     *
     * @param value
     *            the new cocu
     */
    public void setCocu(final String value) {
        cocu = value;
    }

    /**
     * Gets the opet.
     *
     * @return the opet
     */
    public String getOpet() {
        return opet;
    }

    /**
     * Sets the opet.
     *
     * @param value
     *            the new opet
     */
    public void setOpet(final String value) {
        opet = value;
    }

    /**
     * Gets the navt.
     *
     * @return the navt
     */
    public ParametroVO getNavt() {
        return navt;
    }

    /**
     * Sets the navt.
     *
     * @param value
     *            the new navt
     */
    public void setNavt(final ParametroVO value) {
        navt = value;
    }

    /**
     * Gets the pais.
     *
     * @return the pais
     */
    public ParametroVO getPais() {
        return pais;
    }

    /**
     * Sets the pais.
     *
     * @param value
     *            the new pais
     */
    public void setPais(final ParametroVO value) {
        pais = value;
    }

    /**
     * Gets the cantidad.
     *
     * @return the cantidad
     */
    public Double getCantidad() {
        return cantidad;
    }

    /**
     * Sets the cantidad.
     *
     * @param value
     *            the new cantidad
     */
    public void setCantidad(final Double value) {
        cantidad = value;
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
     * Gets the prto.
     *
     * @return the prto
     */
    public final PuertoVO getPrto() {
        return prto;
    }

    /**
     * Sets the prto.
     *
     * @param value
     *            the new prto
     */
    public final void setPrto(final PuertoVO value) {
        prto = value;
    }

}
