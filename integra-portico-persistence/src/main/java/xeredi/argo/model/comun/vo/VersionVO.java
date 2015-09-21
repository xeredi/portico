package xeredi.argo.model.comun.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemVersionVO.
 */
public abstract class VersionVO {

    /** The id. */
    protected Long id;

    /** The fini. */
    protected Date fini;

    /** The ffin. */
    protected Date ffin;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    public final void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the fini.
     *
     * @return the fini
     */
    public final Date getFini() {
        return fini;
    }

    /**
     * Sets the fini.
     *
     * @param value
     *            the new fini
     */
    public final void setFini(final Date value) {
        fini = value;
    }

    /**
     * Gets the ffin.
     *
     * @return the ffin
     */
    public final Date getFfin() {
        return ffin;
    }

    /**
     * Sets the ffin.
     *
     * @param value
     *            the new ffin
     */
    public final void setFfin(final Date value) {
        ffin = value;
    }

}
