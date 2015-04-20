package xeredi.integra.model.seguridad.vo;

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
    public void setAccnIds(final Set<Long> value) {
        accnIds = value;
    }

}
