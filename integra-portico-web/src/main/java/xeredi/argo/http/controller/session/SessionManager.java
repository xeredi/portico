package xeredi.argo.http.controller.session;

import java.util.Map;

import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.bo.ResultadoLoginVO;
import xeredi.argo.model.seguridad.bo.UsuarioAccesoBO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.opensymphony.xwork2.ActionContext;

// TODO: Auto-generated Javadoc
/**
 * The Class SessionManager.
 */
public final class SessionManager {

    /**
     * The Enum ParamNames.
     */
    enum ParamNames {
        /** The login result. */
        loginResult
    }

    /**
     * Instantiates a new session manager.
     */
    private SessionManager() {
        super();
    }

    /**
     * Checks if is authenticated.
     *
     * @param action
     *            the action
     * @return true, if is authenticated
     */
    public static boolean isAuthenticated(final BaseAction action) {
        return getSession().containsKey(ParamNames.loginResult.name());
    }

    /**
     * Checks for permission.
     *
     * @param prefix
     *            the prefix
     * @param codigo
     *            the codigo
     * @return true, if successful
     */
    public static boolean hasPermission(final AccionPrefix prefix, final String codigo) {
        final AccionBO accnBO = new AccionBO();

        return accnBO.exists(prefix, codigo,
                ((ResultadoLoginVO) getSession().get(ParamNames.loginResult.name())).getUsroId());
    }

    /**
     * Checks for permission.
     *
     * @param prefix
     *            the prefix
     * @param codigo
     *            the codigo
     * @param entiId
     *            the enti id
     * @return true, if successful
     */
    public static boolean hasPermission(final AccionPrefix prefix, final String codigo, final Long entiId) {
        final AccionBO accnBO = new AccionBO();

        return accnBO.exists(prefix, codigo, entiId, ((ResultadoLoginVO) getSession()
                .get(ParamNames.loginResult.name())).getUsroId());
    }

    /**
     * Login.
     *
     * @param login
     *            the login
     * @param password
     *            the password
     * @return the resultado login vo
     * @throws ApplicationException
     *             the application exception
     */
    public static ResultadoLoginVO login(final String login, final String password) throws ApplicationException {
        final UsuarioAccesoBO usacBO = new UsuarioAccesoBO();

        final ResultadoLoginVO resultadoLogin = usacBO.acceso(login, password);

        getSession().put(ParamNames.loginResult.name(), resultadoLogin);

        return resultadoLogin;
    }

    /**
     * Logout.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public static void logout() throws ApplicationException {
        getSession().clear();
    }

    /**
     * Gets the session.
     *
     * @return the session
     */
    private static Map<String, Object> getSession() {
        return ActionContext.getContext().getSession();
    }
}
