package xeredi.integra.model.vo.maestro;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroVersionCriterioVO.
 */
public final class SubparametroVersionCriterioVO {
    
    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The fecha vigencia. */
    private Date fechaVigencia;

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
     * @param value the new id
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
     * @param value the new ids
     */
    public void setIds(Set<Long> value) {
        this.ids = value;
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value the new fecha vigencia
     */
    public void setFechaVigencia(Date value) {
        this.fechaVigencia = value;
    }

}
