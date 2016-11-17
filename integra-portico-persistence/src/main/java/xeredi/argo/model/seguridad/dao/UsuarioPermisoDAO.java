package xeredi.argo.model.seguridad.dao;

import xeredi.argo.model.seguridad.vo.UsuarioPermisoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * DAO de verificacion de permisos de usuario.
 *
 * @author xeredi
 */
public interface UsuarioPermisoDAO {

    /**
     * Exists.
     *
     * @param usprCriterio
     *            the uspr criterio
     * @return true, if successful
     */
    boolean exists(final UsuarioPermisoCriterioVO usprCriterio);
}
