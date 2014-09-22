package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioVO.
 */
public final class TipoSubservicioVO extends EntidadVO {

    /** The tpsr id. */
    private Long tpsrId;

    /** The temporal. */
    private Boolean temporal;

    /** The facturable. */
    private Boolean facturable;

    /** The tpdt estado. */
    private TipoDatoVO tpdtEstado;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the tpsr id.
     *
     * @return the tpsr id
     */
    public Long getTpsrId() {
        return tpsrId;
    }

    /**
     * Sets the tpsr id.
     *
     * @param value
     *            the new tpsr id
     */
    public void setTpsrId(final Long value) {
        tpsrId = value;
    }

    /**
     * Gets the temporal.
     *
     * @return the temporal
     */
    public Boolean getTemporal() {
        return temporal;
    }

    /**
     * Sets the temporal.
     *
     * @param value
     *            the new temporal
     */
    public void setTemporal(final Boolean value) {
        temporal = value;
    }

    /**
     * Gets the facturable.
     *
     * @return the facturable
     */
    public Boolean getFacturable() {
        return facturable;
    }

    /**
     * Sets the facturable.
     *
     * @param value
     *            the new facturable
     */
    public void setFacturable(final Boolean value) {
        facturable = value;
    }

    /**
     * Gets the tpdt estado.
     *
     * @return the tpdt estado
     */
    public TipoDatoVO getTpdtEstado() {
        return tpdtEstado;
    }

    /**
     * Sets the tpdt estado.
     *
     * @param value
     *            the new tpdt estado
     */
    public void setTpdtEstado(final TipoDatoVO value) {
        tpdtEstado = value;
    }

}
