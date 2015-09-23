package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.comun.vo.Versionable;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoVO.
 */
public final class AspectoCargoVO implements Versionable<AspectoCargoVersionVO> {

    /** The id. */
    private Long id;

    /** The aspc id. */
    private Long aspcId;

    /** The crgo. */
    private CargoVO crgo;

    /** The ascv. */
    private AspectoCargoVersionVO version;

    /** The fref. */
    private Date fref;

    /**
     * Instantiates a new aspecto cargo vo.
     */
    public AspectoCargoVO() {
        super();

        version = new AspectoCargoVersionVO();
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
     * {@inheritDoc}
     */
    @Override
    public AspectoCargoVersionVO getVersion() {
        return version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVersion(final AspectoCargoVersionVO value) {
        version = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFref() {
        return fref;
    }

    /**
     * Sets the fref.
     *
     * @param value
     *            the new fref
     */
    public void setFref(final Date value) {
        fref = value;
    }
}