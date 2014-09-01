package xeredi.util.j2ee.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class CacheFilter.
 */
public final class CacheFilter implements Filter {

    /** The reply headers. */
    private String[][] replyHeaders = { {} };

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(final FilterConfig config) {
        Enumeration<?> names = config.getInitParameterNames();
        ArrayList<String[]> tmp = new ArrayList<>();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String value = config.getInitParameter(name);
            String[] pair = { name, value };
            tmp.add(pair);
        }
        replyHeaders = new String[tmp.size()][2];
        tmp.toArray(replyHeaders);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        for (String[] replyHeader : replyHeaders) {
            String name = replyHeader[0];
            String value = replyHeader[1];
            httpResponse.addHeader(name, value);
        }
        chain.doFilter(request, response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() {
        // noop
    }
}
