package xeredi.integra.model.estadistica.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaVO.
 */
public final class EstadisticaVO extends ItemVO {
    /** The prpr id. */
    private PeriodoProcesoVO pepr;

    /** The autp. */
    private ParametroVO subp;

    /**
     * Instantiates a new estadistica vo.
     */
    public EstadisticaVO() {
        super();

        pepr = new PeriodoProcesoVO();
        subp = new ParametroVO();
    }

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
    public String getEtiqueta() {
        // FIXME Implementar
        return null;
    }

    /**
     * Gets the subp.
     *
     * @return the subp
     */
    public ParametroVO getSubp() {
        return subp;
    }

    /**
     * Sets the subp.
     *
     * @param value
     *            the new subp
     */
    public void setSubp(final ParametroVO value) {
        subp = value;
    }

    /**
     * Gets the pepr.
     *
     * @return the pepr
     */
    public PeriodoProcesoVO getPepr() {
        return pepr;
    }

    /**
     * Sets the pepr.
     *
     * @param value
     *            the new pepr
     */
    public void setPepr(final PeriodoProcesoVO value) {
        pepr = value;
    }

}
