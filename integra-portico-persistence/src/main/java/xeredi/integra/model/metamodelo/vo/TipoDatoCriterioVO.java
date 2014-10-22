package xeredi.integra.model.metamodelo.vo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.util.pagination.Criterio;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoCriterioVO.
 */
public final class TipoDatoCriterioVO implements Criterio {

    /** The offset. */
    private Integer offset;

    /** The limit. */
    private Integer limit;

    /** The idioma. */
    private String idioma;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The codigo. */
    private String codigo;

    /** The nombre. */
    private String nombre;

    /** The tipo elemento. */
    private TipoElemento tipoElemento;

    /** The tpht id. */
    private TipoHtml tpht;

    /** The tppr id. */
    private Long entiId;

    /** The enti ref id. */
    private Long entiRefId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     * @param value
     *            the new ids
     */
    public void setIds(final Set<Long> value) {
        ids = value;
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
     * Gets the tipo elemento.
     *
     * @return the tipo elemento
     */
    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    /**
     * Sets the tipo elemento.
     *
     * @param value
     *            the new tipo elemento
     */
    public void setTipoElemento(final TipoElemento value) {
        tipoElemento = value;
    }

    /**
     * Gets the tpht id.
     *
     * @return the tpht id
     */
    public TipoHtml getTpht() {
        return tpht;
    }

    /**
     * Sets the tpht id.
     *
     * @param value
     *            the new tpht id
     */
    public void setTpht(final TipoHtml value) {
        tpht = value;
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
     * Gets the offset.
     *
     * @return the offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Sets the offset.
     *
     * @param value
     *            the new offset
     */
    public void setOffset(final Integer value) {
        offset = value;
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
     * Gets the enti ref id.
     *
     * @return the enti ref id
     */
    public Long getEntiRefId() {
        return entiRefId;
    }

    /**
     * Sets the enti ref id.
     *
     * @param value
     *            the new enti ref id
     */
    public void setEntiRefId(final Long value) {
        entiRefId = value;
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
