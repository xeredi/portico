package xeredi.integra.http.controller.action;

// TODO: Auto-generated Javadoc
/**
 * The Class PaginableAction.
 */
public abstract class PaginableAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7826699633865206640L;

    /** The page. */
    private int page;

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
