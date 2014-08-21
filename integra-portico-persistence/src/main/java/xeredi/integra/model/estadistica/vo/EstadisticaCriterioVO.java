package xeredi.integra.model.estadistica.vo;

import java.util.Map;

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
     * {@inheritDoc}
     */
    @Override
    protected void fillSpecificSearchLinks(Map<String, Object> map) {
        if (pepr != null) {
            if (pepr.getId() != null) {
                map.put("pepr.id", pepr.getId());
            }
            if (pepr.getAnio() != null) {
                map.put("pepr.anio", pepr.getAnio());
            }
            if (pepr.getMes() != null) {
                map.put("pepr.mes", pepr.getMes());
            }
            if (pepr.getAutpId() != null) {
                map.put("pepr.autpId", pepr.getAutpId());
            }
        }
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
