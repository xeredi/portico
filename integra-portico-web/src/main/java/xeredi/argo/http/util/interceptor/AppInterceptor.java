package xeredi.argo.http.util.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.http.controller.action.comun.ProtectedAction;
import xeredi.argo.http.controller.action.item.ProtectedItemAction;
import xeredi.argo.http.controller.action.seguridad.UsuarioAccesoAction;
import xeredi.argo.http.controller.session.SessionManager;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionInterceptor.
 */
public final class AppInterceptor extends AbstractInterceptor {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2275010347766981914L;

    /** The log. */
    private static Log LOG = LogFactory.getLog(AppInterceptor.class);

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
                if (action instanceof ProtectedAction) {
                    if (action instanceof ProtectedItemAction) {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Accion de item - entiId: " + ((ProtectedItemAction) action).getEntiId()
                                    + ", accnPrefix: " + ((ProtectedItemAction) action).getAccnPrefix()
                                    + ", accnCodigo: " + ((ProtectedItemAction) action).getAccnCodigo());
                        }
                    } else {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Accion - accnPrefix: " + ((ProtectedAction) action).getAccnPrefix()
                                    + ", accnCodigo: " + ((ProtectedAction) action).getAccnCodigo());
                        }
                    }
                }

                if (SessionManager.isAuthenticated(action)) {
                    final String requestURI = ServletActionContext.getRequest().getRequestURI().replace("/web", "")
                            .replace(".action", "");

                    LOG.info("RequestURI: " + requestURI);

                    result = invocation.invoke();
                } else {
                    result = Action.LOGIN;
                }
            }
        } catch (final ApplicationException ex) {
            action.addActionError(ex.getMessage(action.getLocale()));

            if (LOG.isDebugEnabled()) {
                LOG.debug(ex, ex);
            }
        } catch (final Throwable ex) {
            action.addActionError(MessageI18nKey.E00000, ex.getMessage());

            LOG.fatal(ex, ex);
        }

        action.setResponseCode(result);

        return Action.SUCCESS;
    }

}
