package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroVO.
 */
public final class TipoParametroVO extends EntidadVO {

    /** The i18n. */
    private Boolean i18n;

    /** The temp exp. */
    private Boolean tempExp;

    /** The tpdt nombre id. */
    private TipoDatoVO tpdtNombre;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Checks if is i18n.
     *
     * @return true, if is i18n
     */
    public Boolean getI18n() {
        return i18n;
    }

    /**
     * Sets the i18n.
     *
     * @param value
     *            the new i18n
     */
    public void setI18n(final Boolean value) {
        i18n = value;
    }

    /**
     * Checks if is temp exp.
     *
     * @return true, if is temp exp
     */
    public Boolean getTempExp() {
        return tempExp;
    }

    /**
     * Sets the temp exp.
     *
     * @param value
     *            the new temp exp
     */
    public void setTempExp(final Boolean value) {
        tempExp = value;
    }

    /**
     * Gets the tpdt nombre id.
     *
     * @return the tpdt nombre id
     */
    public final TipoDatoVO getTpdtNombre() {
        return tpdtNombre;
    }

    /**
     * Sets the tpdt nombre id.
     *
     * @param value
     *            the new tpdt nombre id
     */
    public final void setTpdtNombre(final TipoDatoVO value) {
        tpdtNombre = value;
    }

}
