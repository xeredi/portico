package xeredi.integra.http.controller.action;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class PaginableAction.
 */
public abstract class PaginableAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7826699633865206640L;

    /** The rows per page default. */
    public static final int ROWS_PER_PAGE_DEFAULT = 20;

    /** The valid rows per page. */
    public static final int[] VALID_ROWS_PER_PAGE = new int[] { 10, 20, 50, 100, 200, 500 };

    /** The page. */
    private int page = PaginatedList.FIRST_PAGE;

    /** The limit. */
    private int limit = ROWS_PER_PAGE_DEFAULT;

    /**
     * Gets the page.
     *
     * @return the page
     */
    public final int getPage() {
        return page;
    }

    /**
     * Sets the page.
     *
     * @param value
     *            the new page
     */
    public final void setPage(final int value) {
        page = value;
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public final int getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     *
     * @param value
     *            the new limit
     */
    public final void setLimit(final int value) {
        limit = value;
    }

    /**
     * Gets the offset.
     *
     * @return the offset
     */
    public final int getOffset() {
        return (page - PaginatedList.FIRST_PAGE) * limit;
    }

    /**
     * Gets the limits.
     *
     * @return the limits
     */
    public final int[] getLimits() {
        return VALID_ROWS_PER_PAGE;
    }

}
