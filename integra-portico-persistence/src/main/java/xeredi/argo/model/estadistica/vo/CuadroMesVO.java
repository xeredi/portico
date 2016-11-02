package xeredi.argo.model.estadistica.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Identifiable;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesVO.
 */
@Data
public final class CuadroMesVO implements Identifiable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.cdms;

    /** The id. */
    private Long id;

    /** The pepr id. */
    private Long peprId;

    /** The prto. */
    private PuertoVO prto;

    /** The cocu. */
    private String cocu;

    /** The opet. */
    private String opet;

    /** The navt. */
    private ParametroVO navt;

    /** The pais. */
    private ParametroVO pais;

    /** The cantidad. */
    private Double cantidad;
}
