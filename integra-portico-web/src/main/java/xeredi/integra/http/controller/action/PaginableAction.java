package xeredi.integra.http.controller.action;

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

}
