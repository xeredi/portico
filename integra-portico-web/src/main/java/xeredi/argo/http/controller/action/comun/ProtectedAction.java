package xeredi.argo.http.controller.action.comun;

import java.util.Set;

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
    String getAccnCodigo();

    void setAccionesUsuario(final Set<String> acciones);

    Set<String> getAccionesUsuario();
}
