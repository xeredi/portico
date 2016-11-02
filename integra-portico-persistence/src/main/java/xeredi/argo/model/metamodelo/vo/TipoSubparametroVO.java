package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoSubparametroVO extends EntidadVO {
    /** The tppr. */
    private Long tpprId;

    /** The tppr asociado. */
    private TipoParametroVO tpprAsociado;

    /** The i18n. */
    private boolean i18n;

    /** The temp exp. */
    private boolean tempExp;
}
