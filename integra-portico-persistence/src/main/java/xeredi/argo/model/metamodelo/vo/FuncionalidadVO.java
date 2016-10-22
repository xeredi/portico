package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new funcionalidad vo.
 */
@Data
public class FuncionalidadVO {

    /** The id. */
    private Long id;

    /** The prefix. */
    private AccionPrefix prefix;

    /** The path. */
    private String path;

    /** The i18n id. */
    private Long i18nId;
}
