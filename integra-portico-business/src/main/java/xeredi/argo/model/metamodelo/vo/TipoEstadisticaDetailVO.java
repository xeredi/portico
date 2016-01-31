package xeredi.argo.model.metamodelo.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new tipo estadistica detail vo.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoEstadisticaDetailVO extends AbstractEntidadDetailVO {

    /** The tpes. */
    private TipoEstadisticaVO enti;

    /** The cmag list. */
    private List<CampoAgregacionVO> cmagList;

    /** The cmdi list. */
    private List<CampoDimensionVO> cmdiList;

    public EstadisticaVO createItem() {
        final EstadisticaVO item = new EstadisticaVO();

        fillItem(item);

        return item;
    }
}
