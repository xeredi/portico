package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.VersionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoVersionVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AspectoCargoVersionVO extends VersionVO {
    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.ascv;
}
