package xeredi.argo.model.proceso.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCriterioVO.
 */
@Data
public final class ProcesoCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The modulo. */
    private ProcesoModulo modulo;

    /** The tipo. */
    private ProcesoTipo tipo;

    /** The estado. */
    private ProcesoEstado estado;

    /** The falta min. */
    private Date faltaMin;

    /** The falta max. */
    private Date faltaMax;
}
