package xeredi.integra.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ArchivoCriterioVO.
 */
public final class ArchivoCriterioVO {

    /** The id. */
    private Long id;

    /** The srvc id. */
    private Long srvcId;

    /** The prbt id. */
    private Long prbtId;

    /** The sentido. */
    private ArchivoSentido sentido;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     * Gets the prbt id.
     *
     * @return the prbt id
     */
    public Long getPrbtId() {
        return prbtId;
    }

    /**
     * Sets the prbt id.
     *
     * @param value
     *            the new prbt id
     */
    public void setPrbtId(final Long value) {
        prbtId = value;
    }

    /**
     * Gets the sentido.
     *
     * @return the sentido
     */
    public ArchivoSentido getSentido() {
        return sentido;
    }

    /**
     * Sets the sentido.
     *
     * @param value
     *            the new sentido
     */
    public void setSentido(final ArchivoSentido value) {
        sentido = value;
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

}
