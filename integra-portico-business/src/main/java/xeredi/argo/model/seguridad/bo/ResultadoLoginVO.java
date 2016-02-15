package xeredi.argo.model.seguridad.bo;

import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.NonNull;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ResultadoLoginVO.
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Data
public final class ResultadoLoginVO {

    /** The usro id. */
    private final Long usroId;

    /** The nombre. */
    private final String nombre;

    /** The sprt. */
    private final SuperpuertoVO sprt;

    /** The prto. */
    private final PuertoVO prto;

    /** The accn paths. */
    private final Set<String> accnPaths;

    /** The acen paths. */
    private final Map<Long, Set<String>> acenPaths;

    /** The actr paths. */
    private final Map<Long, Set<String>> actrPaths;

    /**
     * Instantiates a new resultado login vo.
     *
     * @param ausroId
     *            the ausro id
     * @param anombre
     *            the anombre
     * @param asprt
     *            the asprt
     * @param aprto
     *            the aprto
     * @param aaccnPaths
     *            the aaccn paths
     * @param aacenPaths
     *            the aacen paths
     * @param aactrPaths
     *            the aactr paths
     */
    public ResultadoLoginVO(final @NonNull Long ausroId, final @NonNull String anombre, final SuperpuertoVO asprt,
            final PuertoVO aprto, final Set<String> aaccnPaths, final Map<Long, Set<String>> aacenPaths,
            final Map<Long, Set<String>> aactrPaths) {
        super();
        usroId = ausroId;
        nombre = anombre;
        sprt = asprt;
        prto = aprto;
        accnPaths = aaccnPaths;
        acenPaths = aacenPaths;
        actrPaths = aactrPaths;
    }
}
