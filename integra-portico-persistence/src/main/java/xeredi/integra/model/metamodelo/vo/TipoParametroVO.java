package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroVO.
 */
public final class TipoParametroVO extends EntidadVO {

    /** The i18n. */
    private boolean i18n;

    /** The temp exp. */
    private boolean tempExp;

    /** The tpdt nombre id. */
    private Long tpdtNombreId;

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
    public boolean isI18n() {
        return i18n;
    }

    /**
     * Sets the i18n.
     * 
     * @param value
     *            the new i18n
     */
    public void setI18n(final boolean value) {
        i18n = value;
    }

    /**
     * Checks if is temp exp.
     * 
     * @return true, if is temp exp
     */
    public boolean isTempExp() {
        return tempExp;
    }

    /**
     * Sets the temp exp.
     * 
     * @param value
     *            the new temp exp
     */
    public void setTempExp(final boolean value) {
        tempExp = value;
    }

    /**
     * Gets the tpdt nombre id.
     * 
     * @return the tpdt nombre id
     */
    public final Long getTpdtNombreId() {
        return tpdtNombreId;
    }

    /**
     * Sets the tpdt nombre id.
     * 
     * @param value
     *            the new tpdt nombre id
     */
    public final void setTpdtNombreId(Long value) {
        this.tpdtNombreId = value;
    }

}
