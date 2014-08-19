package xeredi.integra.model.vo.facturacion;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaLineaCriterioVO.
 */
public final class FacturaLineaCriterioVO {

    /** The fctr. */
    private FacturaCriterioVO fctr;

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
     * Gets the fctr.
     *
     * @return the fctr
     */
    public FacturaCriterioVO getFctr() {
        return fctr;
    }

    /**
     * Sets the fctr.
     *
     * @param value
     *            the fctr
     */
    public void setFctr(FacturaCriterioVO value) {
        this.fctr = value;
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
