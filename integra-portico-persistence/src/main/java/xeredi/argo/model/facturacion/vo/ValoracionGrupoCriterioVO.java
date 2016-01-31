package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionGrupoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ValoracionGrupoCriterioVO extends BaseCriterioVO {

    /**
     * The Enum GrupoTipo.
     */
    enum GrupoTipo {
        /** The p. */
        P,
        /** The t. */
        T,
        /** The s. */
        S;
    }

    /** The grupo tipo. */
    private GrupoTipo grupoTipo;

    /** The prto. */
    private PuertoVO prto;

    /** The pagador. */
    private ParametroVO pagador;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The srvc. */
    private ServicioVO srvc;

    /** The vlrc. */
    private ValoracionVO vlrc;
}
