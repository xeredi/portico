package xeredi.argo.http.controller.action.comun;

import xeredi.argo.model.seguridad.vo.AccionCodigo;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

public interface ProtectedAction {
    /**
     * Gets the prefix.
     *
     * @return the prefix
     */
    AccionPrefix getAccnPrefix();

    /**
     * Gets the accn codigo.
     *
     * @return the accn codigo
     */
    AccionCodigo getAccion();
}
