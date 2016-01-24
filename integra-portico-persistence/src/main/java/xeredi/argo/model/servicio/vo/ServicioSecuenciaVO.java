package xeredi.argo.model.servicio.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaVO.
 */
@Data
public final class ServicioSecuenciaVO {

    /** The tpsr id. */
    private TipoServicioVO tpsr;

    /** The subp id. */
    private PuertoVO prto;

    /** The anno. */
    private Integer anno;

    /** The ultimo numero. */
    private Integer ultimoNumero;
}
