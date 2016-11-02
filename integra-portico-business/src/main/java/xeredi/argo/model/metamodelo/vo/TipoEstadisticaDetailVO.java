package xeredi.argo.model.metamodelo.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;

/**
 * The Class TipoEstadisticaDetailVO.
 */
// TODO: Auto-generated Javadoc
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoEstadisticaDetailVO extends AbstractEntidadDetailVO {

    /** The tpes. */
    private TipoEstadisticaVO enti;

    /** The cmag list. */
    private List<CampoAgregacionVO> cmagList;

    /** The cmdi list. */
    private List<CampoDimensionVO> cmdiList;

    /**
     * Creates the item.
     *
     * @return the estadistica VO
     */
    public EstadisticaVO createItem() {
        final EstadisticaVO item = new EstadisticaVO();

        fillItem(item);

        return item;
    }
}
