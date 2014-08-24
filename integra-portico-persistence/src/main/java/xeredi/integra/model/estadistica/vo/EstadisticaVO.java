package xeredi.integra.model.estadistica.vo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaVO.
 */
public final class EstadisticaVO extends ItemVO {
    /** The prpr id. */
    private PeriodoProcesoVO pepr;

    /** The autp. */
    private ParametroVO autp;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * New instance.
     * 
     * @param tpesVO
     *            the tpes vo
     * @return the estadistica vo
     */
    public static EstadisticaVO newInstance(final TipoEstadisticaVO tpesVO) {
        final EstadisticaVO estdVO = new EstadisticaVO();

        estdVO.setEntiId(tpesVO.getId());

        if (tpesVO.getEntdList() != null && !tpesVO.getEntdList().isEmpty()) {
            final Map<Long, ItemDatoVO> itdtMap = new HashMap<>();

            for (final Long tpdtId : tpesVO.getEntdList()) {
                final ItemDatoVO itdtVO = new ItemDatoVO();

                itdtVO.setTpdtId(tpdtId);
                itdtMap.put(itdtVO.getTpdtId(), itdtVO);
            }

            estdVO.setItdtMap(itdtMap);
        }

        return estdVO;
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
     * Gets the autp.
     * 
     * @return the autp
     */
    public ParametroVO getAutp() {
        return autp;
    }

    /**
     * Sets the autp.
     * 
     * @param value
     *            the new autp
     */
    public void setAutp(final ParametroVO value) {
        autp = value;
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
    public void setPepr(PeriodoProcesoVO value) {
        this.pepr = value;
    }

}