package xeredi.integra.model.maestro.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroI18n.
 */
public final class ParametroI18nVO {

    /** The prvr id. */
    private Long prvrId;

    /** The idioma. */
    private String idioma;

    /** The texto. */
    private String texto;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the prvr id.
     * 
     * @return the prvr id
     */
    public Long getPrvrId() {
        return prvrId;
    }

    /**
     * Sets the prvr id.
     * 
     * @param value
     *            the new prvr id
     */
    public void setPrvrId(final Long value) {
        prvrId = value;
    }

    /**
     * Gets the idioma.
     * 
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Sets the idioma.
     * 
     * @param value
     *            the new idioma
     */
    public void setIdioma(final String value) {
        idioma = value;
    }

    /**
     * Gets the texto.
     * 
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Sets the texto.
     * 
     * @param value
     *            the new texto
     */
    public void setTexto(final String value) {
        if (value != null) {
            texto = value.trim().toUpperCase();
        }
    }

}
