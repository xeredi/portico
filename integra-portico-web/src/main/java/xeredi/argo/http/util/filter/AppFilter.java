package xeredi.argo.http.util.filter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import com.google.inject.servlet.GuiceFilter;

import xeredi.argo.model.comun.bo.I18nJs;

// TODO: Auto-generated Javadoc
/**
 * The Class AppFilter.
 */
public final class AppFilter extends /*StrutsPrepareAndExecuteFilter*/ GuiceFilter {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AppFilter.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(final FilterConfig config) throws ServletException {
        super.init(config);

        try {
            final I18nJs i18nJs = new I18nJs();

            i18nJs.export();
        } catch (final Throwable ex) {
            LOG.fatal(ex, ex);

            throw new ServletException(ex);
        }


    }
}
