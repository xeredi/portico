package xeredi.argo.model.item.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteDatoVO.
 */
@Data
public final class ItemTramiteDatoVO {

    /** The ittr id. */
    private Long ittrId;

    /** The tpdt id. */
    private Long tpdtId;

    /** The onentero. */
    private Long onentero;

    /** The ondecimal. */
    private Double ondecimal;

    /** The ocadena. */
    private String ocadena;

    /** The ofecha. */
    private Date ofecha;

    /** The oprmt. */
    private ParametroVO oprmt;

    /** The osrvc. */
    private ServicioVO osrvc;

    /** The dnentero. */
    private Long dnentero;

    /** The dndecimal. */
    private Double dndecimal;

    /** The dcadena. */
    private String dcadena;

    /** The dfecha. */
    private Date dfecha;

    /** The dprmt. */
    private ParametroVO dprmt;

    /** The dsrvc. */
    private ServicioVO dsrvc;
}
