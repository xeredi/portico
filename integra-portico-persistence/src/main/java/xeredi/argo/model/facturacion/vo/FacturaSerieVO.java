package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Identifiable;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieVO.
 */
@Data
public final class FacturaSerieVO implements Identifiable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.fcsr;

    /** The id. */
    private Long id;

    /** The serie. */
    private String serie;

    /** The anio. */
    private Integer anio;

    /** The numero ultimo. */
    private Integer numeroUltimo;
}
