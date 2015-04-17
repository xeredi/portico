package xeredi.integra.model.comun.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseCriterioVO.
 */
public abstract class BaseCriterioVO {

    /** The idioma. */
    private String idioma;

    /** The idioma defecto. */
    private String idiomaDefecto;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The max limit. */
    private Integer maxLimit;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the idioma.
     *
     * @return the idioma
     */
    public final String getIdioma() {
        return idioma;
    }

    /**
     * Sets the idioma.
     *
     * @param value
     *            the new idioma
     */
    public final void setIdioma(final String value) {
        idioma = value;
    }

    /**
     * Gets the idioma defecto.
     *
     * @return the idioma defecto
     */
    public final String getIdiomaDefecto() {
        return idiomaDefecto;
    }

    /**
     * Sets the idioma defecto.
     *
     * @param value
     *            the new idioma defecto
     */
    public final void setIdiomaDefecto(final String value) {
        idiomaDefecto = value;
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public final Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public final void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

    /**
     * Gets the max limit.
     *
     * @return the max limit
     */
    public final Integer getMaxLimit() {
        return maxLimit;
    }

    /**
     * Sets the max limit.
     *
     * @param value
     *            the new max limit
     */
    public final void setMaxLimit(final Integer value) {
        maxLimit = value;
    }

    /**
     * Gets the texto busqueda.
     *
     * @return the texto busqueda
     */
    public final String getTextoBusqueda() {
        return textoBusqueda;
    }

    /**
     * Sets the texto busqueda.
     *
     * @param value
     *            the new texto busqueda
     */
    public final void setTextoBusqueda(final String value) {
        if (value != null) {
            textoBusqueda = value.trim().toUpperCase() + "%";
        }
    }
}
