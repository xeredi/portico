package xeredi.argo.model.seguridad.vo;

import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.NonNull;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class ResultadoLoginVO.
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

    /** The orga. */
    private final ParametroVO orga;

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
     * @param aorga
     *            the aorga
     * @param amdloSet
     *            the amdlo set
     * @param aacbsPaths
     *            the aacbs paths
     * @param aacenMap
     *            the aacen map
     * @param afncdIds
     *            the afncd ids
     */
    public ResultadoLoginVO(@NonNull final Long ausroId, @NonNull final String anombre, final SuperpuertoVO asprt,
            final PuertoVO aprto, final ParametroVO aorga, @NonNull final Set<String> amdloSet,
            @NonNull final Set<String> aacbsPaths, @NonNull final Map<Long, Set<AccionCodigo>> aacenMap,
            @NonNull final Set<Long> afncdIds) {
        super();
        usroId = ausroId;
        nombre = anombre;
        sprt = asprt;
        prto = aprto;
        orga = aorga;
        mdloSet = amdloSet;
        acbsPaths = aacbsPaths;
        acenMap = aacenMap;
        fncdIds = afncdIds;
    }
}
