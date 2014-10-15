package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaI18nCriterioVO.
 */
public final class CodigoReferenciaI18nCriterioVO {

    /** The cdrf id. */
    private Long cdrfId;

    /** The idioma. */
    private String idioma;

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

}
