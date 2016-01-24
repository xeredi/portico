package xeredi.argo.model.servicio.vo;

import java.util.Date;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoradorVO.
 */
@Data
public final class ValoradorVO {
    /** The enti id. */
    private ServicioVO srvc;

    /** The fliq. */
    private Date fliq;

    /** The crgo ids. */
    private Set<Long> crgoIds;

    /** The prbt. */
    private ProcesoVO prbt;
}
