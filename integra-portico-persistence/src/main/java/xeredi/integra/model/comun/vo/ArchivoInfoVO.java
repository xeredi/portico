package xeredi.integra.model.comun.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ArchivoInfoVO.
 */
public final class ArchivoInfoVO {

    /** The id. */
    private Long id;

    /** The filename. */
    private String nombre;

    /** The filesize. */
    private Long tamanio;

    /** The sentido. */
    private ArchivoSentido sentido;

    /** The falta. */
    private Date falta;

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
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
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

    /**
     * Gets the tamanio.
     *
     * @return the tamanio
     */
    public Long getTamanio() {
        return tamanio;
    }

    /**
     * Sets the tamanio.
     *
     * @param value
     *            the new tamanio
     */
    public void setTamanio(final Long value) {
        tamanio = value;
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

}
