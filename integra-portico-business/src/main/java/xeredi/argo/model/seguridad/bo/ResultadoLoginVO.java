package xeredi.argo.model.seguridad.bo;

import java.util.Set;

import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ResultadoLoginVO.
 */
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
     */
    public ResultadoLoginVO(final Long ausroId, final String anombre, final SuperpuertoVO asprt, final PuertoVO aprto,
            final Set<String> aaccnPaths) {
        super();
        usroId = ausroId;
        nombre = anombre;
        sprt = asprt;
        prto = aprto;
        accnPaths = aaccnPaths;
    }

    /**
     * Gets the usro id.
     *
     * @return the usro id
     */
    public Long getUsroId() {
        return usroId;
    }

    /**
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Gets the sprt.
     *
     * @return the sprt
     */
    public SuperpuertoVO getSprt() {
        return sprt;
    }

    /**
     * Gets the prto.
     *
     * @return the prto
     */
    public PuertoVO getPrto() {
        return prto;
    }

    /**
     * Gets the accn paths.
     *
     * @return the accn paths
     */
    public Set<String> getAccnPaths() {
        return accnPaths;
    }

}
