package xeredi.integra.model.estadistica.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaAgregadoCriterioVO.
 */
public final class EstadisticaAgregadoCriterioVO {

    /** The finicio. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The pepr id. */
    private Long peprId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the finicio.
     *
     * @return the finicio
     */
    public Date getFini() {
        return fini;
    }

    /**
     * Sets the finicio.
     *
     * @param value
     *            the new finicio
     */
    public void setFini(final Date value) {
        fini = value;
    }

    /**
     * Gets the ffin.
     *
     * @return the ffin
     */
    public Date getFfin() {
        return ffin;
    }

    /**
     * Sets the ffin.
     *
     * @param value
     *            the new ffin
     */
    public void setFfin(final Date value) {
        ffin = value;
    }

    /**
     * Gets the pepr id.
     *
     * @return the pepr id
     */
    public Long getPeprId() {
        return peprId;
    }

    /**
     * Sets the pepr id.
     *
     * @param value
     *            the new pepr id
     */
    public void setPeprId(final Long value) {
        peprId = value;
    }

}
