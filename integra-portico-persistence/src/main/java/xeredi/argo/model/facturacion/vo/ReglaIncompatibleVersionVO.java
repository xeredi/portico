package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.VersionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleVersionVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ReglaIncompatibleVersionVO extends VersionVO {
    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.rgiv;
}
