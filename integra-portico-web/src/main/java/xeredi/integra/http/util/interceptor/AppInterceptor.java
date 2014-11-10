package xeredi.integra.http.util.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionInterceptor.
 */
public final class AppInterceptor extends AbstractInterceptor {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2275010347766981914L;

    private static Log LOG = LogFactory.getLog(AppInterceptor.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public String intercept(final ActionInvocation invocation) throws Exception {
        final BaseAction action = (BaseAction) invocation.getAction();

        String result = BaseAction.SUCCESS;

        try {
            result = invocation.invoke();
        } catch (final ApplicationException ex) {
            action.addActionError(ex.getMessage(action.getLocale()));
        } catch (final Throwable ex) {
            action.addActionError(MessageI18nKey.E00000, ex.getMessage());

            LOG.error(ex, ex);
        }

        return result;
    }

}
