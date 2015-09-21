package xeredi.argo.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionVO.
 */
public final class CampoAgregacionVO {

    /** The tpes id. */
    private Long tpesId;

    /** The entd. */
    private EntidadTipoDatoVO entd;

    /** The agregar. */
    private Boolean agregar;

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
     * Gets the tpes id.
     *
     * @return the tpes id
     */
    public Long getTpesId() {
        return tpesId;
    }

    /**
     * Sets the tpes id.
     *
     * @param value
     *            the new tpes id
     */
    public void setTpesId(final Long value) {
        tpesId = value;
    }

    /**
     * Gets the entd.
     *
     * @return the entd
     */
    public EntidadTipoDatoVO getEntd() {
        return entd;
    }

    /**
     * Sets the entd.
     *
     * @param value
     *            the new entd
     */
    public void setEntd(final EntidadTipoDatoVO value) {
        entd = value;
    }

    /**
     * Gets the agregar.
     *
     * @return the agregar
     */
    public Boolean getAgregar() {
        return agregar;
    }

    /**
     * Sets the agregar.
     *
     * @param value
     *            the new agregar
     */
    public void setAgregar(final Boolean value) {
        agregar = value;
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
