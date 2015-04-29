package xeredi.integra.http.util.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.seguridad.UsuarioAccesoAction;
import xeredi.integra.http.controller.session.SessionManager;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;

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
