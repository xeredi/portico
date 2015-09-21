package xeredi.argo.model.estadistica.vo;

import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.item.vo.ItemCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaCriterioVO.
 */
public final class EstadisticaCriterioVO extends ItemCriterioVO {

    /** The pepr id. */
    private PeriodoProcesoCriterioVO pepr;

    /** The subp id. */
    private PuertoCriterioVO prto;

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

    /**
     * Gets the prto.
     *
     * @return the prto
     */
    public PuertoCriterioVO getPrto() {
        return prto;
    }

    /**
     * Sets the prto.
     *
     * @param value
     *            the new prto
     */
    public void setPrto(final PuertoCriterioVO value) {
        prto = value;
    }
}
