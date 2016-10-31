package xeredi.argo.model.seguridad.vo;

import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.NonNull;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class ResultadoLoginVO.
 */

/*
 * (non-Javadoc)
 *
 * @see java.lang.Object#toString()
 */

/**
 * {@inheritDoc}
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

    /** The mdlo set. */
    private final Set<String> mdloSet;

    /** The accn paths. */
    private final Set<String> acbsPaths;

    /** The acen map. */
    private final Map<Long, Set<AccionCodigo>> acenMap;

    /** The acen paths. */
    private final Set<Long> fncdIds;

    /**
     * Instantiates a new resultado login VO.
     *
     * @param ausroId
     *            the ausro id
     * @param anombre
     *            the anombre
     * @param asprt
     *            the asprt
     * @param aprto
     *            the aprto
     * @param amdloSet
     *            the amdlo set
     * @param aacbsPaths
     *            the aacbs paths
     * @param aacenMap
     *            the aacen map
     * @param afncdIds
     *            the afncd ids
     */
    public ResultadoLoginVO(final @NonNull Long ausroId, final @NonNull String anombre, final SuperpuertoVO asprt,
            final PuertoVO aprto, final @NonNull Set<String> amdloSet, final @NonNull Set<String> aacbsPaths,
            final @NonNull Map<Long, Set<AccionCodigo>> aacenMap, final @NonNull Set<Long> afncdIds) {
        super();
        usroId = ausroId;
        nombre = anombre;
        sprt = asprt;
        prto = aprto;
        mdloSet = amdloSet;
        acbsPaths = aacbsPaths;
        acenMap = aacenMap;
        fncdIds = afncdIds;
    }
}
