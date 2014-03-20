package xeredi.integra.model.vo.maestro;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.vo.comun.ItemCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoSubparametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroCriterioVO.
 */
public final class SubparametroCriterioVO extends ItemCriterioVO {

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
     * {@inheritDoc}
     */
    @Override
    protected void fillSpecificSearchLinks(Map<String, Object> map) {
        if (tpsp != null) {
            if (tpsp.getId() != null) {
                map.put("tpsp.id", tpsp.getId());
            }
        }
        if (prmt != null) {
            if (prmt.getId() != null) {
                map.put("prmt.id", prmt.getId());
            }
        }
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
    public void setPrmt(ParametroCriterioVO value) {
        this.prmt = value;
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
    public void setPrmtAsociado(ParametroCriterioVO value) {
        this.prmtAsociado = value;
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
    public void setTpsp(TipoSubparametroCriterioVO value) {
        this.tpsp = value;
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
    public final void setSpvrIds(Set<Long> value) {
        this.spvrIds = value;
    }

}
