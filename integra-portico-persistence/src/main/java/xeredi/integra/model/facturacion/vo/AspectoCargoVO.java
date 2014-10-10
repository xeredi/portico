package xeredi.integra.model.facturacion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoVO.
 */
public final class AspectoCargoVO {

    /** The id. */
    private Long id;

    /** The aspc id. */
    private Long aspcId;

    /** The crgo. */
    private CargoVO crgo;

    /** The ascv. */
    private AspectoCargoVersionVO ascv;

    /**
     * Instantiates a new aspecto cargo vo.
     */
    public AspectoCargoVO() {
        super();

        ascv = new AspectoCargoVersionVO();
    }

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
     * Gets the crgo.
     *
     * @return the crgo
     */
    public CargoVO getCrgo() {
        return crgo;
    }

    /**
     * Sets the crgo.
     *
     * @param value
     *            the new crgo
     */
    public void setCrgo(final CargoVO value) {
        crgo = value;
    }

    /**
     * Gets the ascv.
     *
     * @return the ascv
     */
    public AspectoCargoVersionVO getAscv() {
        return ascv;
    }

    /**
     * Sets the ascv.
     *
     * @param value
     *            the new ascv
     */
    public void setAscv(final AspectoCargoVersionVO value) {
        ascv = value;
    }

}
