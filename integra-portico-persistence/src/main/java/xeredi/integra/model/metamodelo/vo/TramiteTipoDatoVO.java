package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoVO.
 */
public final class TramiteTipoDatoVO {

    /** The trmt id. */
    private Long trmtId;

    /** The tpdt. */
    private EntidadTipoDatoVO entd;

    /** The obligatorio. */
    private boolean obligatorio;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the trmt id.
     *
     * @return the trmt id
     */
    public Long getTrmtId() {
        return trmtId;
    }

    /**
     * Sets the trmt id.
     *
     * @param value
     *            the new trmt id
     */
    public void setTrmtId(final Long value) {
        trmtId = value;
    }

    /**
     * Gets the tpdt.
     *
     * @return the tpdt
     */
    public EntidadTipoDatoVO getEntd() {
        return entd;
    }

    /**
     * Sets the tpdt.
     *
     * @param value
     *            the new tpdt
     */
    public void setEntd(final EntidadTipoDatoVO value) {
        entd = value;
    }

    /**
     * Checks if is obligatorio.
     *
     * @return true, if is obligatorio
     */
    public boolean isObligatorio() {
        return obligatorio;
    }

    /**
     * Sets the obligatorio.
     *
     * @param value
     *            the new obligatorio
     */
    public void setObligatorio(final boolean value) {
        obligatorio = value;
    }
}
