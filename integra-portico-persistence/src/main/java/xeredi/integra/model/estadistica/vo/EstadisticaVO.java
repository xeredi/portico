package xeredi.integra.model.estadistica.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.item.vo.ItemVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaVO.
 */
public final class EstadisticaVO extends ItemVO {
    /** The prpr id. */
    private PeriodoProcesoVO pepr;

    /** The autp. */
    private PuertoVO prto;

    /**
     * Instantiates a new estadistica vo.
     */
    public EstadisticaVO() {
        super();
    }

    /**
     * Instantiates a new estadistica vo.
     *
     * @param entiDetail
     *            the enti detail
     */
    public EstadisticaVO(final TipoEstadisticaDetailVO entiDetail) {
        super(entiDetail);
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
     * Gets the prto.
     *
     * @return the prto
     */
    public PuertoVO getPrto() {
        return prto;
    }

    /**
     * Sets the prto.
     *
     * @param value
     *            the new prto
     */
    public void setPrto(final PuertoVO value) {
        prto = value;
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
