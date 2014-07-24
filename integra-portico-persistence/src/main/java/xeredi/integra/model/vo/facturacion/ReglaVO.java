package xeredi.integra.model.vo.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.vo.metamodelo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaVO.
 */
public final class ReglaVO {

    /** The id. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The crgo. */
    private CargoVO crgo;

    /** The enti. */
    private EntidadVO enti;

    /** The tipo. */
    private ReglaTipo tipo;

    /** The rglv. */
    private ReglaVersionVO rglv;

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
     * @param value
     *            the codigo
     */
    public void setCodigo(String value) {
        this.codigo = value;
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
     * Gets the enti.
     *
     * @return the enti
     */
    public EntidadVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the enti
     */
    public void setEnti(EntidadVO value) {
        this.enti = value;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public ReglaTipo getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param value
     *            the tipo
     */
    public void setTipo(ReglaTipo value) {
        this.tipo = value;
    }

    /**
     * Gets the rglv.
     *
     * @return the rglv
     */
    public ReglaVersionVO getRglv() {
        return rglv;
    }

    /**
     * Sets the rglv.
     *
     * @param value
     *            the rglv
     */
    public void setRglv(ReglaVersionVO value) {
        this.rglv = value;
    }

}
