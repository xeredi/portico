package xeredi.argo.http.controller.action.comun;

import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

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
