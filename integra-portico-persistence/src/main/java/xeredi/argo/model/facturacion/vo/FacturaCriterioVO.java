package xeredi.argo.model.facturacion.vo;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class FacturaCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The estado. */
    private FacturaEstado estado;

    /** The fcsr. */
    private Long vlrcId;

    /** The tpsr id. */
    private Long tpsrId;

    /** The pagador id. */
    private ParametroVO pagador;

    /** Servicio. */
    private ServicioVO srvc;
}
