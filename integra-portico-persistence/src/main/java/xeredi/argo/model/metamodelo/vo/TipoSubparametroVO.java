package xeredi.argo.model.metamodelo.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroVO.
 */
@Data
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
