package xeredi.argo.model.servicio.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.item.vo.ItemTypeahead;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioLupaCriterioVO.
 */
@Data
public final class SubservicioLupaCriterioVO extends BaseCriterioVO implements ItemTypeahead {
    /** The enti id. */
    private Long entiId;

    /** The texto busqueda. */
    private Integer numero;

    /** The srvc id. */
    private Long srvcId;

    /** The texto busqueda. */
    private String textoBusqueda;
}
