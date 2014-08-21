package xeredi.integra.model.facturacion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoVO.
 */
public final class AspectoVO {

    /** The id. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The descripcion. */
    private String descripcion;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The aspv. */
    private AspectoVersionVO aspv;

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
     * Gets the codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     *
     * @param value the codigo
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Gets the descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the descripcion.
     *
     * @param value the descripcion
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
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
     * @param value the tpsr
     */
    public void setTpsr(TipoServicioVO value) {
        this.tpsr = value;
    }

    /**
     * Gets the aspv.
     *
     * @return the aspv
     */
    public AspectoVersionVO getAspv() {
        return aspv;
    }

    /**
     * Sets the aspv.
     *
     * @param value the aspv
     */
    public void setAspv(AspectoVersionVO value) {
        this.aspv = value;
    }

}
