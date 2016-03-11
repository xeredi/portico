package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionGrupoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ValoracionGrupoCriterioVO extends BaseCriterioVO {

    /** The grupo tipo. */
    private ValoracionGrupoTipo grupoTipo;

    /** The prto. */
    private PuertoVO prto;

    /** The pagador. */
    private ParametroVO pagador;

    /** The tpsr. */
    private Long tpsrId;

    /** The srvc. */
    private ServicioVO srvc;

    /** The vlrc. */
    private Long vlrcId;
}
