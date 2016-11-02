package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Identifiable;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new funcionalidad vo.
 */
@Data
public class FuncionalidadVO implements Identifiable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.fncd;

    /** The id. */
    private Long id;
}
