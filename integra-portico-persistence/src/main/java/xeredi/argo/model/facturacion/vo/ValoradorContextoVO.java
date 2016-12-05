package xeredi.argo.model.facturacion.vo;

import java.util.Date;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.proceso.vo.ProcesoVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionContextoVO.
 */
@Data
public final class ValoradorContextoVO {

    /** The prbt. */
    private ProcesoVO prbt;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The srvc. */
    private ServicioVO srvc;

    /** The crgo. */
    private CargoVO crgo;

    /** The fecha liquidacion. */
    private Date fliquidacion;

    /** The fecha inicio. */
    private Date fini;

    /** The fecha fin. */
    private Date ffin;

    /** The fecha referencia. */
    private Date fref;

    /** The rgla. */
    private ReglaVO rgla;

    /** The estados vlrc set. */
    private Set<String> estadosVlrcSet;

    /** The aspc. */
    private AspectoVO aspc;
}
