package xeredi.integra.model.maestro.vo;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroCriterioVO.
 */
public final class SubparametroCriterioVO extends ItemCriterioVO {

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The spvr id. */
    private Long spvrId;

    /** The spvr ids. */
    private Set<Long> spvrIds;

    /** The tpsp. */
    private TipoSubparametroCriterioVO tpsp;

    /** The prmt. */
    private ParametroCriterioVO prmt;

    /** The prmt asociado. */
    private ParametroCriterioVO prmtAsociado;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

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
    public final Set<Long> getSpvrIds() {
        return spvrIds;
    }

    /**
     * Sets the spvr ids.
     *
     * @param value
     *            the new spvr ids
     */
    public final void setSpvrIds(final Set<Long> value) {
        spvrIds = value;
    }

    /**
     * Gets the spvr id.
     *
     * @return the spvr id
     */
    public Long getSpvrId() {
        return spvrId;
    }

    /**
     * Sets the spvr id.
     *
     * @param value
     *            the new spvr id
     */
    public void setSpvrId(final Long value) {
        spvrId = value;
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

}
