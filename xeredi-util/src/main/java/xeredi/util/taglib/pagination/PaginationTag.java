package xeredi.util.taglib.pagination;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class PaginationTag.
 */
public final class PaginationTag extends BodyTagSupport {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(PaginationTag.class);

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 702724100729241080L;

    /** The href. */
    private transient String href;

    /** The search criteria. */
    private transient Object searchCriteria;

    /** The targets. */
    private transient String targets;

    /** The total pages. */
    private transient Integer totalPages;

    /** The current page. */
    private Integer currentPage;

    /** The total results. */
    private transient Integer totalResults;

    /**
     * {@inheritDoc}
     */
    @Override
    public int doEndTag() throws JspException {
        try {
            // this.pageContext.getOut().write(this.getJavascriptContent());
            pageContext.getOut().write(getDivContent());
        } catch (final IOException ex) {
            LOG.error("Error", ex);
        }

        return EVAL_PAGE;
    }

    /**
     * Devuelve el valor de div content.
     * 
     * @return El valor de div content
     */
    private String getDivContent() {
        final StringBuilder builder = new StringBuilder();

        currentPage++;

        int startPage = currentPage - 2;
        int endPage = currentPage + 2;

        if (startPage < 1) {
            startPage = 1;
            endPage = 7;
        }

        if (endPage > totalPages) {
            endPage = totalPages;
            startPage = totalPages - 6;
        }

        if (startPage < 1) {
            startPage = 1;
        }

        builder.append("<style type='text/css'>.pagination li {display: inline; padding: 5px;}.pagination li.selected {}</style>");

        builder.append("<ul class='pagination' id='").append(id).append("'>");

        if (currentPage > 1) {
            builder.append(this.getItem(currentPage - 1, "&lt;&lt;&lt; Anterior"));
        } else {
            builder.append(this.getItem("&lt;&lt;&lt; Anterior"));
        }

        if (startPage > 1) {
            builder.append(this.getItem(1, "1"));
        }

        if (startPage > 2) {
            int rePage = currentPage - 5;

            if (rePage < 2) {
                rePage = 2;
            }

            builder.append(this.getItem(rePage, "..."));
        }

        for (int i = startPage; i <= endPage; i++) {
            if (i == currentPage) {
                builder.append(this.getItem(String.valueOf(i)));
            } else {
                builder.append(this.getItem(i, String.valueOf(i)));
            }
        }

        if (endPage < totalPages - 2) {
            int avPage = currentPage + 5;

            if (avPage > totalPages) {
                avPage = totalPages;
            }

            builder.append(this.getItem(avPage, "..."));
        }

        if (currentPage < totalPages) {
            builder.append(this.getItem(currentPage + 1, "Siguiente &gt;&gt;&gt;"));
        } else {
            builder.append(this.getItem("Siguiente"));
        }

        builder.append("</ul>");

        return builder.toString();
    }

    /**
     * Devuelve el valor de item.
     * 
     * @param page
     *            the page
     * @param label
     *            the label
     * @return El valor de item
     */
    private StringBuilder getItem(final int page, final String label) {
        final StringBuilder builder = new StringBuilder();

        builder.append("<li><a href='").append(href).append(builder.indexOf("?") < 0 ? '?' : '&')
                .append("page=").append(page - 1).append("'>").append(label).append("</a></li>");

        return builder;
    }

    /**
     * Devuelve el valor de item.
     * 
     * @param label
     *            the label
     * @return El valor de item
     */
    private StringBuilder getItem(final String label) {
        final StringBuilder builder = new StringBuilder();

        builder.append("<li class='selected'><b>").append(label).append("</b></li>");

        return builder;
    }

    /**
     * Modifica el valor de href.
     * 
     * @param value
     *            El nuevo valor.
     */
    public void setHref(final String value) {
        href = value;
    }

    /**
     * Modifica el valor de search criteria.
     * 
     * @param value
     *            El nuevo valor.
     */
    public void setSearchCriteria(final Object value) {
        searchCriteria = value;
    }

    /**
     * Modifica el valor de targets.
     * 
     * @param value
     *            El nuevo valor.
     */
    public void setTargets(final String value) {
        targets = value;
    }

    /**
     * Modifica el valor de total pages.
     * 
     * @param value
     *            El nuevo valor.
     */
    public void setTotalPages(final Integer value) {
        totalPages = value;
    }

    /**
     * Modifica el valor de current page.
     * 
     * @param value
     *            El nuevo valor.
     */
    public void setCurrentPage(final Integer value) {
        currentPage = value;
    }

    /**
     * Modifica el valor de total results.
     * 
     * @param value
     *            El nuevo valor.
     */
    public void setTotalResults(final Integer value) {
        totalResults = value;
    }

}
