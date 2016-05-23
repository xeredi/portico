package xeredi.argo.model.estadistica.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.item.vo.ItemVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class EstadisticaVO extends ItemVO {
    /** The prpr id. */
    private PeriodoProcesoVO pepr;

    /** The autp. */
    private PuertoVO prto;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEtiqueta() {
        // FIXME Implementar
        return null;
    }
}
