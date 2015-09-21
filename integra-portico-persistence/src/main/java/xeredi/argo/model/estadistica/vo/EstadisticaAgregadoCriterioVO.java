package xeredi.argo.model.estadistica.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaAgregadoCriterioVO.
 */
public final class EstadisticaAgregadoCriterioVO {

    /** The pepr id. */
    private final Long peprId;

    /** The sprt id. */
    private final Long sprtId;

    /** The finicio. */
    private final Date fini;

    /** The ffin. */
    private final Date ffin;

    /**
     * Instantiates a new estadistica agregado criterio vo.
     *
     * @param apeprId
     *            the apepr id
     * @param asprtId
     *            the asprt id
     * @param afini
     *            the afini
     * @param affin
     *            the affin
     */
    public EstadisticaAgregadoCriterioVO(final Long apeprId, final Long asprtId, final Date afini, final Date affin) {
        super();
        peprId = apeprId;
        sprtId = asprtId;
        fini = afini;
        ffin = affin;
    }

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
     * Gets the ffin.
     *
     * @return the ffin
     */
    public Date getFfin() {
        return ffin;
    }

    /**
     * Gets the pepr id.
     *
     * @return the pepr id
     */
    public Long getPeprId() {
        return peprId;
    }
}
