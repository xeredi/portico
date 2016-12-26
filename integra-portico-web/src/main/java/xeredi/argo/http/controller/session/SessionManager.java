package xeredi.argo.http.controller.session;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import lombok.NonNull;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.model.comun.exception.ApplicationException;
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
	private enum ParamNames {
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
	public static boolean isAuthenticated(@NonNull final BaseAction action) {
		return getSession().containsKey(ParamNames.loginResult.name());
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
	public static ResultadoLoginVO login(@NonNull final String login, @NonNull final String password)
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
	 */
	public static Long getUsroId() {
		return getSession().containsKey(ParamNames.loginResult.name())
				? ((ResultadoLoginVO) getSession().get(ParamNames.loginResult.name())).getUsroId() : null;
	}

	/**
	 * Gets the sprt id.
	 *
	 * @return the sprt id
	 */
	public static Long getSprtId() {
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
