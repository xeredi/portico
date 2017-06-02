package xeredi.argo.http.util.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Inject;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.http.controller.action.comun.ProtectedAction;
import xeredi.argo.http.controller.action.item.FuncionalidadAction;
import xeredi.argo.http.controller.action.item.ProtectedItemAction;
import xeredi.argo.http.controller.action.seguridad.UsuarioAccesoAction;
import xeredi.argo.http.controller.session.SessionManager;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.seguridad.service.UsuarioPermisoService;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionInterceptor.
 */
public final class AppInterceptor extends AbstractInterceptor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2275010347766981914L;

	/** The log. */
	private static Log LOG = LogFactory.getLog(AppInterceptor.class);

	@Inject
	private UsuarioPermisoService usprService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String intercept(final ActionInvocation invocation) throws Exception {
		final BaseAction action = (BaseAction) invocation.getAction();

		String result = Action.SUCCESS;

		try {
			if (action instanceof UsuarioAccesoAction) {
				result = invocation.invoke();
			} else {
				if (SessionManager.isAuthenticated(action)) {
					if (action instanceof ProtectedAction) {
						final ClassPrefix prefix = action.getPrefix();
						final AccionCodigo codigo = ((ProtectedAction) action).getAccion();

						if (action instanceof ProtectedItemAction) {
							final Long entiId = ((ProtectedItemAction) action).getEntiId();

							if (!usprService.hasAcen(SessionManager.getUsroId(), prefix.name(), codigo.name(),
									entiId)) {
								action.addActionError(MessageI18nKey.E00015, prefix.name(), codigo);
							}
						} else {
							if (!usprService.hasAcbs(SessionManager.getUsroId(), prefix.name(), codigo.name())) {
								action.addActionError(MessageI18nKey.E00015, prefix.name(), codigo);
							}
						}
					}

					if (action instanceof FuncionalidadAction) {
						final Long fncdId = ((FuncionalidadAction) action).getFncdId();

						if (!usprService.hasFncd(SessionManager.getUsroId(), fncdId)) {
							action.addActionError(MessageI18nKey.E00015, fncdId);
						}
					}

					if (!action.hasErrors()) {
						result = invocation.invoke();
					}
				} else {
					result = Action.LOGIN;
				}
			}
		} catch (final ApplicationException ex) {
			action.addActionError(ex.getMessage(action.getBundle(action.getLocale())));

			if (LOG.isDebugEnabled()) {
				LOG.debug(ex, ex);
			}
		} catch (final Throwable ex) {
			action.addActionError(MessageI18nKey.E00000, ex.getMessage());

			LOG.fatal(ex, ex);
		}

		action.setResponseCode(action.hasErrors() ? Action.ERROR : result);

		return Action.SUCCESS;
	}

}
