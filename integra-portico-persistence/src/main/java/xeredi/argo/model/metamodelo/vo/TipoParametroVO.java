package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoParametroVO extends EntidadVO {

    /** The i18n. */
    private boolean i18n;

    /** The temp exp. */
    private boolean tempExp;

    /** The tpdt nombre id. */
    private TipoDatoVO tpdtNombre;
}
