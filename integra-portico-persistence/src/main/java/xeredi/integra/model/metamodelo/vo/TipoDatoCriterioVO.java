package xeredi.integra.model.metamodelo.vo;

import java.util.Set;

import xeredi.integra.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoCriterioVO.
 */
public final class TipoDatoCriterioVO extends BaseCriterioVO {

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
