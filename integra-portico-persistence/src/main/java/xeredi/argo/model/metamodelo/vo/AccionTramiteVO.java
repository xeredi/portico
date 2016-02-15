package xeredi.argo.model.metamodelo.vo;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.seguridad.vo.AccionVO;

/**
 * Accion de un Trámite.
 */
@Data
public final class AccionTramiteVO {
    /** Identificador único de acción de trámite. */
    private Long id;

    /** Acción. */
    private AccionVO accn;

    /** Identificador de trámite. */
    private Long trmtId;

    /** {@link Set} de identificadores de gupos de usuario con permiso para realizar la acción de trámite. */
    private Set<Long> grpoIds = new HashSet<>();
}
