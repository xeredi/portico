package xeredi.integra.model.vo.metamodelo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroVO.
 */
public final class TipoSubparametroVO extends EntidadVO {

    /** The tppr. */
    private TipoParametroVO tppr;

    /** The tppr asociado. */
    private TipoParametroVO tpprAsociado;

    /** The i18n. */
    private boolean i18n;

    /** The temp exp. */
    private boolean tempExp;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the tppr.
     * 
     * @return the tppr
     */
    public TipoParametroVO getTppr() {
        return tppr;
    }

    /**
     * Sets the tppr.
     * 
     * @param value
     *            the new tppr
     */
    public void setTppr(final TipoParametroVO value) {
        tppr = value;
    }

    /**
     * Gets the tppr asociado.
     * 
     * @return the tppr asociado
     */
    public TipoParametroVO getTpprAsociado() {
        return tpprAsociado;
    }

    /**
     * Sets the tppr asociado.
     * 
     * @param value
     *            the new tppr asociado
     */
    public void setTpprAsociado(final TipoParametroVO value) {
        tpprAsociado = value;
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

}
