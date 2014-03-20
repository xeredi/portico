package xeredi.integra.model.vo.proceso;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoArchivoVO.
 */
public final class ProcesoArchivoVO {

    /** The prbt id. */
    private Long prbtId;

    /** The sentido. */
    private ArchivoSentido sentido;

    /** The nombre. */
    private String nombre;

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
     * Gets the sentido.
     * 
     * @return the sentido
     */
    public ArchivoSentido getSentido() {
        return sentido;
    }

    /**
     * Sets the sentido.
     * 
     * @param value
     *            the new sentido
     */
    public void setSentido(final ArchivoSentido value) {
        sentido = value;
    }

    /**
     * Gets the nombre.
     * 
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     * 
     * @param value
     *            the new nombre
     */
    public void setNombre(final String value) {
        nombre = value;
    }

}
