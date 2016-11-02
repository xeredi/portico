package xeredi.argo.model.seguridad.vo;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Identifiable;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoVO.
 */
@Data
public final class GrupoVO implements Identifiable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.grpo;

    /** The id. */
    private Long id;

    /** The nombre. */
    private String nombre;

    /** The accn ids. */
    private Set<Long> fncdIds = new HashSet<>();
}
