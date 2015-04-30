package xeredi.integra.model.maestro.vo;

import java.util.Date;
import java.util.Set;

import xeredi.integra.model.comun.vo.ItemCriterioVO;
import xeredi.integra.model.comun.vo.Typeahead;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroCriterioVO.
 */
public final class SubparametroCriterioVO extends ItemCriterioVO implements Typeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The spvr id. */
    private Long versionId;

    /** The spvr ids. */
    private Set<Long> versionIds;

    /** The tpsp. */
    private TipoSubparametroCriterioVO tpsp;

    /** The prmt. */
    private ParametroCriterioVO prmt;

    /** The prmt asociado. */
    private ParametroCriterioVO prmtAsociado;

    /**
     * Gets the prmt.
     *
     * @return the prmt
     */
    public ParametroCriterioVO getPrmt() {
        return prmt;
    }

    /**
     * Sets the prmt.
     *
     * @param value
     *            the new prmt
     */
    public void setPrmt(final ParametroCriterioVO value) {
        prmt = value;
    }

    /**
     * Gets the prmt asociado.
     *
     * @return the prmt asociado
     */
    public ParametroCriterioVO getPrmtAsociado() {
        return prmtAsociado;
    }

    /**
     * Sets the prmt asociado.
     *
     * @param value
     *            the new prmt asociado
     */
    public void setPrmtAsociado(final ParametroCriterioVO value) {
        prmtAsociado = value;
    }

    /**
     * Gets the tpsp.
     *
     * @return the tpsp
     */
    public TipoSubparametroCriterioVO getTpsp() {
        return tpsp;
    }

    /**
     * Sets the tpsp.
     *
     * @param value
     *            the new tpsp
     */
    public void setTpsp(final TipoSubparametroCriterioVO value) {
        tpsp = value;
    }

    /**
     * Gets the spvr ids.
     *
     * @return the spvr ids
     */
    public final Set<Long> getVersionIds() {
        return versionIds;
    }

    /**
     * Sets the spvr ids.
     *
     * @param value
     *            the new spvr ids
     */
    public final void setVersionIds(final Set<Long> value) {
        versionIds = value;
    }

    /**
     * Gets the spvr id.
     *
     * @return the spvr id
     */
    public Long getVersionId() {
        return versionId;
    }

    /**
     * Sets the spvr id.
     *
     * @param value
     *            the new spvr id
     */
    public void setVersionId(final Long value) {
        versionId = value;
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
