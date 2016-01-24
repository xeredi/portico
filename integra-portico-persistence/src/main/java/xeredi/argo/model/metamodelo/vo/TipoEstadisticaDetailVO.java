package xeredi.argo.model.metamodelo.vo;

import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaDetailVO.
 */
@Data
public final class TipoEstadisticaDetailVO extends AbstractEntidadDetailVO {

    /** The tpes. */
    private TipoEstadisticaVO enti;

    /** The cmag list. */
    private List<CampoAgregacionVO> cmagList;
}
