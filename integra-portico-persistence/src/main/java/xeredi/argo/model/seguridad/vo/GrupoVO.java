package xeredi.argo.model.seguridad.vo;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoVO.
 */
@Data
public final class GrupoVO {

    /** The id. */
    private Long id;

    /** The nombre. */
    private String nombre;

    /** The accn ids. */
    private Set<Long> fncdIds = new HashSet<>();
}
