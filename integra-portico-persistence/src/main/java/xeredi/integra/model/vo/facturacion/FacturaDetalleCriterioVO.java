package xeredi.integra.model.vo.facturacion;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetalleCriterioVO.
 */
public final class FacturaDetalleCriterioVO {

    /** The fctl. */
    private FacturaLineaCriterioVO fctl;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the fctl.
     *
     * @return the fctl
     */
    public FacturaLineaCriterioVO getFctl() {
        return fctl;
    }

    /**
     * Sets the fctl.
     *
     * @param value
     *            the fctl
     */
    public void setFctl(FacturaLineaCriterioVO value) {
        this.fctl = value;
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

}
