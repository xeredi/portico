package xeredi.argo.model.item.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadDatoVO.
 */
@Data
public final class ItemDatoVO {
    /** The srvc id. */
    private Long itemId;

    /** The tpdt id. */
    private Long tpdtId;

    /** The cantidad entera. */
    private Long cantidadEntera;

    /** The cantidad decimal. */
    private Double cantidadDecimal;

    /** The fecha. */
    private Date fecha;

    /** The prmt. */
    private ParametroVO prmt;

    /** The srvc. */
    private ServicioVO srvc;

    /** The cadena. */
    private String cadena;
}
