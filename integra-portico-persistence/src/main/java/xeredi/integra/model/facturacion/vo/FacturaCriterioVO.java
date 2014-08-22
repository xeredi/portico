package xeredi.integra.model.facturacion.vo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaCriterioVO.
 */
public final class FacturaCriterioVO {

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The estado. */
    private FacturaEstado estado;

    /** The fcsr. */
    private FacturaServicioCriterioVO fcts;

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
     *            the id
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the ids.
     *
     * @return the ids
     */
    public Set<Long> getIds() {
        return ids;
    }

    /**
     * Sets the ids.
     *
     * @param value
     *            the ids
     */
    public void setIds(Set<Long> value) {
        this.ids = value;
    }

    /**
     * Gets the fcsr.
     *
     * @return the fcsr
     */
    public FacturaServicioCriterioVO getFcts() {
        return fcts;
    }

    /**
     * Sets the fcsr.
     *
     * @param value
     *            the fcsr
     */
    public void setFcts(FacturaServicioCriterioVO value) {
        this.fcts = value;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public FacturaEstado getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param value
     *            the estado
     */
    public void setEstado(FacturaEstado value) {
        this.estado = value;
    }

}
