package xeredi.integra.model.vo.maestro;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroVersionVO.
 */
public final class SubparametroVersionVO {
    /** The id. */
    private Long id;

    /** The finicio. */
    private Date finicio;

    /** The ffin. */
    private Date ffin;

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
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the finicio.
     * 
     * @return the finicio
     */
    public Date getFinicio() {
        return finicio;
    }

    /**
     * Sets the finicio.
     * 
     * @param value
     *            the new finicio
     */
    public void setFinicio(Date value) {
        this.finicio = value;
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
    public void setFfin(Date value) {
        this.ffin = value;
    }

}
