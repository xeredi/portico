package xeredi.argo.http.controller.session;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import lombok.NonNull;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.AccionBaseBO;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.bo.FuncionalidadBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.seguridad.bo.UsuarioAccesoBO;
import xeredi.argo.model.seguridad.vo.ResultadoLoginVO;

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
    public static boolean isAuthenticated(final @NonNull BaseAction action) {
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
    public static boolean hasPermission(final @NonNull ClassPrefix prefix, final @NonNull AccionCodigo codigo) {
        final AccionBaseBO acbsBO = new AccionBaseBO();

        return acbsBO.isUserAllowed(prefix, codigo,
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
    public static boolean hasPermission(final @NonNull ClassPrefix prefix, final @NonNull AccionCodigo codigo,
            final @NonNull Long entiId) {
        final AccionEntidadBO acenBO = new AccionEntidadBO();

        return acenBO.isUserAllowed(prefix, codigo, entiId,
                ((ResultadoLoginVO) getSession().get(ParamNames.loginResult.name())).getUsroId());
    }

    /**
     * Checks for permission.
     *
     * @param fncdId
     *            the fncd id
     * @return true, if successful
     */
    public static boolean hasPermission(final @NonNull Long fncdId) {
        final FuncionalidadBO fncdBO = new FuncionalidadBO();

        return fncdBO.isUserAllowed(fncdId,
                ((ResultadoLoginVO) getSession().get(ParamNames.loginResult.name())).getUsroId());
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
    public static ResultadoLoginVO login(final @NonNull String login, final @NonNull String password)
            throws ApplicationException {
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
     * Gets the usro id.
     *
     * @return the usro id
     * @throws ApplicationException
     *             the application exception
     */
    public static Long getUsroId() throws ApplicationException {
        return getSession().containsKey(ParamNames.loginResult.name())
                ? ((ResultadoLoginVO) getSession().get(ParamNames.loginResult.name())).getUsroId() : null;
    }

    /**
     * Gets the sprt id.
     *
     * @return the sprt id
     * @throws ApplicationException
     *             the application exception
     */
    public static Long getSprtId() throws ApplicationException {
        return getSession().containsKey(ParamNames.loginResult.name())
                ? ((ResultadoLoginVO) getSession().get(ParamNames.loginResult.name())).getSprt().getId() : null;
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
