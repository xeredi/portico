package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Modelable;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoVO.
 */
@Data
public final class TramiteTipoDatoVO implements Modelable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.trtd;

    /** The trmt id. */
    private Long trmtId;

    /** The tpdt. */
    private EntidadTipoDatoVO entd;

    /** The obligatorio. */
    private Boolean obligatorio;
}
