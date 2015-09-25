package xeredi.argo.model.seguridad.vo;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoVO.
 */
public final class GrupoVO {

    /** The id. */
    private Long id;

    /** The nombre. */
    private String nombre;

    /** The accn ids. */
    private Set<Long> accnIds;

    /** The acen ids. */
    private Set<Long> acenIds;

    /**
     * Instantiates a new grupo vo.
     */
    public GrupoVO() {
        super();

        accnIds = new HashSet<>();
        acenIds = new HashSet<>();
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
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     *
     * @param value
     *            the new nombre
     */
    public void setNombre(final String value) {
        nombre = value;
    }

    /**
     * Gets the accn ids.
     *
     * @return the accn ids
     */
    public Set<Long> getAccnIds() {
        return accnIds;
    }

    /**
     * Sets the accn ids.
     *
     * @param value
     *            the new accn ids
     */
    public void setAccnIds(Set<Long> value) {
        this.accnIds = value;
    }

    /**
     * Gets the acen ids.
     *
     * @return the acen ids
     */
    public Set<Long> getAcenIds() {
        return acenIds;
    }

    /**
     * Sets the acen ids.
     *
     * @param value
     *            the new acen ids
     */
    public void setAcenIds(Set<Long> value) {
        this.acenIds = value;
    }
}
