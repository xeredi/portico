package xeredi.argo.model.estadistica.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaVO.
 */
@Data
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
    public String getEtiqueta() {
        // FIXME Implementar
        return null;
    }
}
