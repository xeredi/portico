package xeredi.argo.model.facturacion.vo;

import java.util.Date;
import java.util.Set;

import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.comun.vo.Typeahead;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaCriterioVO.
 */
public final class ReglaCriterioVO extends BaseCriterioVO implements Typeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The incompatible id. */
    private Long incompatibleId;

    /** The tipo. */
    private ReglaTipo tipo;

    /** The crgo id. */
    private Long crgoId;

    /** The vlrc id. */
    private Long vlrcId;

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
     *            the id
     */
    public void setId(final Long value) {
        id = value;
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
     *            the ids
     */
    public void setIds(final Set<Long> value) {
        ids = value;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public ReglaTipo getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param value
     *            the tipo
     */
    public void setTipo(final ReglaTipo value) {
        tipo = value;
    }

    /**
     * Gets the crgo id.
     *
     * @return the crgo id
     */
    public Long getCrgoId() {
        return crgoId;
    }

    /**
     * Sets the crgo id.
     *
     * @param value
     *            the crgo id
     */
    public void setCrgoId(final Long value) {
        crgoId = value;
    }

    /**
     * Gets the incompatible id.
     *
     * @return the incompatible id
     */
    public Long getIncompatibleId() {
        return incompatibleId;
    }

    /**
     * Sets the incompatible id.
     *
     * @param value
     *            the new incompatible id
     */
    public void setIncompatibleId(final Long value) {
        incompatibleId = value;
    }

    /**
     * Gets the vlrc id.
     *
     * @return the vlrc id
     */
    public Long getVlrcId() {
        return vlrcId;
    }

    /**
     * Sets the vlrc id.
     *
     * @param value
     *            the vlrc id
     */
    public void setVlrcId(final Long value) {
        vlrcId = value;
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
     * {@inheritDoc}
     */
    @Override
    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTextoBusqueda(final String value) {
        textoBusqueda = value;
    }

}
