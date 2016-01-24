package xeredi.argo.model.facturacion.vo;

import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionCriterioVO.
 */
@Data
public final class ValoracionCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The tpsr id. */
    private Long tpsrId;

    /** The prto id. */
    private Long prtoId;

    /** The srvc id. */
    private ServicioVO srvc;

    /** The pagador id. */
    private ParametroVO pagador;

    /** The aspc. */
    private AspectoVO aspc;

    /** The crgo. */
    private CargoVO crgo;

    /** The fctr. */
    private FacturaVO fctr;

    /** The cod exencion. */
    private String codExencion;
}
