package xeredi.argo.model.maestro.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.VersionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroVersionVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class ParametroVersionVO extends VersionVO {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.prvr;

    /** The lat. */
    private Double lat;

    /** The lon. */
    private Double lon;
}
