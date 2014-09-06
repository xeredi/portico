package xeredi.integra.model.facturacion.vo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionCriterioVO.
 */
public final class ValoracionCriterioVO {

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The aspc id. */
    private Long aspcId;

    /** The srvc id. */
    private Long srvcId;

    /** The pagador id. */
    private Long pagadorId;

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
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
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
    public void setIds(final Set<Long> value) {
        ids = value;
    }

    /**
     * Gets the aspc id.
     *
     * @return the aspc id
     */
    public Long getAspcId() {
        return aspcId;
    }

    /**
     * Sets the aspc id.
     *
     * @param value
     *            the new aspc id
     */
    public void setAspcId(final Long value) {
        aspcId = value;
    }

    /**
     * Gets the srvc id.
     *
     * @return the srvc id
     */
    public Long getSrvcId() {
        return srvcId;
    }

    /**
     * Sets the srvc id.
     *
     * @param value
     *            the new srvc id
     */
    public void setSrvcId(final Long value) {
        srvcId = value;
    }

    /**
     * Gets the pagador id.
     *
     * @return the pagador id
     */
    public Long getPagadorId() {
        return pagadorId;
    }

    /**
     * Sets the pagador id.
     *
     * @param value
     *            the new pagador id
     */
    public void setPagadorId(final Long value) {
        pagadorId = value;
    }

}
