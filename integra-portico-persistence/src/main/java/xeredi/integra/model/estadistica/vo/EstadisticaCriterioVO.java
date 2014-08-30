package xeredi.integra.model.estadistica.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaCriterioVO.
 */
public final class EstadisticaCriterioVO extends ItemCriterioVO {

    /** The pepr id. */
    private PeriodoProcesoCriterioVO pepr;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the pepr id.
     *
     * @return the pepr id
     */
    public PeriodoProcesoCriterioVO getPepr() {
        return pepr;
    }

    /**
     * Sets the pepr id.
     *
     * @param value
     *            the new pepr id
     */
    public void setPepr(final PeriodoProcesoCriterioVO value) {
        pepr = value;
    }
}
