package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroVO.
 */
public final class TipoSubparametroVO extends EntidadVO {

    /** The tppr. */
    private Long tpprId;

    /** The tppr asociado. */
    private TipoParametroVO tpprAsociado;

    /** The i18n. */
    private Boolean i18n;

    /** The temp exp. */
    private Boolean tempExp;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the tppr id.
     *
     * @return the tppr id
     */
    public Long getTpprId() {
        return tpprId;
    }

    /**
     * Sets the tppr id.
     *
     * @param value
     *            the new tppr id
     */
    public void setTpprId(final Long value) {
        tpprId = value;
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
     * Gets the i18n.
     *
     * @return the i18n
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
     * Gets the temp exp.
     *
     * @return the temp exp
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

}
