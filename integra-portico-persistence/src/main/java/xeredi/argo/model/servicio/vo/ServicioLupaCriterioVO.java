package xeredi.argo.model.servicio.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.item.vo.ItemTypeahead;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioLupaCriterioVO.
 */
@Data
public final class ServicioLupaCriterioVO extends BaseCriterioVO implements ItemTypeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The enti id. */
    private Long entiId;

    /** The subpuerto. */
    private String subpuerto;

    /** The anno. */
    private String anno;

    /** The numero. */
    private String numero;
}
