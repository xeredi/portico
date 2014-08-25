package xeredi.integra.model.facturacion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleVO.
 */
public final class ReglaIncompatibleVO {

    /** The id. */
    private Long id;

    /** The rgla1 id. */
    private Long rgla1Id;

    /** The rgla2. */
    private ReglaVO rgla2;

    /** The rgiv. */
    private ReglaIncompatibleVersionVO rgiv;

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
     * Gets the rgla1 id.
     *
     * @return the rgla1 id
     */
    public Long getRgla1Id() {
        return rgla1Id;
    }

    /**
     * Sets the rgla1 id.
     *
     * @param value
     *            the new rgla1 id
     */
    public void setRgla1Id(final Long value) {
        rgla1Id = value;
    }

    /**
     * Gets the rgla2.
     *
     * @return the rgla2
     */
    public ReglaVO getRgla2() {
        return rgla2;
    }

    /**
     * Sets the rgla2.
     *
     * @param value
     *            the new rgla2
     */
    public void setRgla2(final ReglaVO value) {
        rgla2 = value;
    }

    /**
     * Gets the rgiv.
     *
     * @return the rgiv
     */
    public ReglaIncompatibleVersionVO getRgiv() {
        return rgiv;
    }

    /**
     * Sets the rgiv.
     *
     * @param value
     *            the new rgiv
     */
    public void setRgiv(final ReglaIncompatibleVersionVO value) {
        rgiv = value;
    }

}
