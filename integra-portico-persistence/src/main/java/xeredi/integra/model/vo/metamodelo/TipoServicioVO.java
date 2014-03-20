package xeredi.integra.model.vo.metamodelo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioVO.
 */
public final class TipoServicioVO extends EntidadVO {

    /** The temporal. */
    private boolean temporal;

    /** The facturable. */
    private boolean facturable;

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
     * Checks if is temporal.
     * 
     * @return true, if is temporal
     */
    public boolean isTemporal() {
        return temporal;
    }

    /**
     * Sets the temporal.
     * 
     * @param value
     *            the new temporal
     */
    public void setTemporal(final boolean value) {
        temporal = value;
    }

    /**
     * Checks if is facturable.
     * 
     * @return true, if is facturable
     */
    public boolean isFacturable() {
        return facturable;
    }

    /**
     * Sets the facturable.
     * 
     * @param value
     *            the new facturable
     */
    public void setFacturable(final boolean value) {
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
    public void setTpdtEstado(TipoDatoVO value) {
        this.tpdtEstado = value;
    }

}
