package xeredi.integra.model.facturacion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
    public void setId(final Long value) {
        id = value;
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
    public void setCodigo(final String value) {
        codigo = value;
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
    public void setCrgo(final CargoVO value) {
        crgo = value;
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
    public void setRglv(final ReglaVersionVO value) {
        rglv = value;
    }

}
