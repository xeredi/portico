package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaI18nVO.
 */
public final class CodigoReferenciaI18nVO {

    /** The cdrf id. */
    private Long cdrfId;

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
     * Gets the cdrf id.
     *
     * @return the cdrf id
     */
    public Long getCdrfId() {
        return cdrfId;
    }

    /**
     * Sets the cdrf id.
     *
     * @param value
     *            the new cdrf id
     */
    public void setCdrfId(final Long value) {
        cdrfId = value;
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
        texto = value;
    }

}
