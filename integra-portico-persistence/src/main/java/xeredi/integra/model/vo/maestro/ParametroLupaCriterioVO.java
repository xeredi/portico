package xeredi.integra.model.vo.maestro;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroLupaCriterioVO.
 */
public final class ParametroLupaCriterioVO {

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The idioma. */
    private String idioma;

    /** The limit. */
    private Integer limit;

    /** The enti id. */
    private Long entiId;

    /** The tpdt nombre id. */
    private Long tpdtNombreId;

    /** The texto busqueda. */
    private String textoBusqueda;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

    /**
     * Gets the idioma.
     * 
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Sets the idioma.
     * 
     * @param value
     *            the new idioma
     */
    public void setIdioma(final String value) {
        idioma = value;
    }

    /**
     * Gets the limit.
     * 
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     * 
     * @param value
     *            the new limit
     */
    public void setLimit(final Integer value) {
        limit = value;
    }

    /**
     * Gets the enti id.
     * 
     * @return the enti id
     */
    public Long getEntiId() {
        return entiId;
    }

    /**
     * Sets the enti id.
     * 
     * @param value
     *            the new enti id
     */
    public void setEntiId(final Long value) {
        entiId = value;
    }

    /**
     * Gets the texto busqueda.
     * 
     * @return the texto busqueda
     */
    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    /**
     * Sets the texto busqueda.
     * 
     * @param value
     *            the new texto busqueda
     */
    public void setTextoBusqueda(final String value) {
        textoBusqueda = value;
    }

    /**
     * Gets the tpdt nombre id.
     * 
     * @return the tpdt nombre id
     */
    public final Long getTpdtNombreId() {
        return tpdtNombreId;
    }

    /**
     * Sets the tpdt nombre id.
     * 
     * @param value
     *            the new tpdt nombre id
     */
    public final void setTpdtNombreId(final Long value) {
        tpdtNombreId = value;
    }

}
