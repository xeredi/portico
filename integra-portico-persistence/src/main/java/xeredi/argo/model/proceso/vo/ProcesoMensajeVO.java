package xeredi.argo.model.proceso.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoMensajeVO.
 */
public final class ProcesoMensajeVO {

    /** The prbt id. */
    private Long prbtId;

    /** The nivel. */
    private MensajeNivel nivel;

    /** The codigo. */
    private MensajeCodigo codigo;

    /** The mensaje. */
    private String mensaje;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the prbt id.
     * 
     * @return the prbt id
     */
    public Long getPrbtId() {
        return prbtId;
    }

    /**
     * Sets the prbt id.
     * 
     * @param value
     *            the new prbt id
     */
    public void setPrbtId(final Long value) {
        prbtId = value;
    }

    /**
     * Gets the nivel.
     * 
     * @return the nivel
     */
    public MensajeNivel getNivel() {
        return nivel;
    }

    /**
     * Sets the nivel.
     * 
     * @param value
     *            the new nivel
     */
    public void setNivel(final MensajeNivel value) {
        nivel = value;
    }

    /**
     * Gets the codigo.
     * 
     * @return the codigo
     */
    public MensajeCodigo getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     * 
     * @param value
     *            the new codigo
     */
    public void setCodigo(final MensajeCodigo value) {
        codigo = value;
    }

    /**
     * Gets the mensaje.
     * 
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Sets the mensaje.
     * 
     * @param value
     *            the new mensaje
     */
    public void setMensaje(final String value) {
        mensaje = value;
    }

}
