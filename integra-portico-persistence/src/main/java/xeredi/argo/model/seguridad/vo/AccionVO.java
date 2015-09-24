package xeredi.argo.model.seguridad.vo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionVO.
 */
public final class AccionVO {

    /** The id. */
    private Long id;

    /** The prefix. */
    private AccionPrefix prefix;

    /** The codigo. */
    private String codigo;

    /** The grpo ids. */
    private Set<Long> grpoIds;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        return (prefix == null ? " - " : prefix.name()) + " - " + codigo;
    }

    /**
     * Gets the codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     *
     * @param value
     *            the new codigo
     */
    public void setCodigo(final String value) {
        codigo = value;
    }

    /**
     * Gets the prefix.
     *
     * @return the prefix
     */
    public AccionPrefix getPrefix() {
        return prefix;
    }

    /**
     * Sets the prefix.
     *
     * @param value
     *            the new prefix
     */
    public void setPrefix(AccionPrefix value) {
        this.prefix = value;
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
     * Gets the grpo ids.
     *
     * @return the grpo ids
     */
    public Set<Long> getGrpoIds() {
        return grpoIds;
    }

    /**
     * Sets the grpo ids.
     *
     * @param value the new grpo ids
     */
    public void setGrpoIds(Set<Long> value) {
        this.grpoIds = value;
    }
}
