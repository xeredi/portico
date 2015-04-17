package xeredi.integra.http.controller.action;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class GridAction.
 *
 * @param <T>
 *            the generic type
 * @param <R>
 *            the generic type
 */
public class GridAction<T, R> extends BaseAction implements ModelDriven<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6180459932256461050L;

    /** The rows per page default. */
    public static final int ROWS_PER_PAGE_DEFAULT = 20;

    /** The valid rows per page. */
    public static final int[] VALID_ROWS_PER_PAGE = new int[] { 10, 20, 50, 100, 200, 500 };

    /** The model. */
    protected T model;

    /** The result list. */
    protected PaginatedList<R> resultList;

    /** The page. */
    protected int page = PaginatedList.FIRST_PAGE;

    /** The limit. */
    protected int limit = ROWS_PER_PAGE_DEFAULT;

    /**
     * Filter.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    public final String filter() throws ApplicationException {
        doFilter();

        return SUCCESS;
    }

    /**
     * List.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    public final String list() throws ApplicationException {
        doList();

        return SUCCESS;
    }

    /**
     * Do filter.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected void doFilter() throws ApplicationException {
        throw new Error("No implementado");
    }

    /**
     * Do list.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected void doList() throws ApplicationException {
        throw new Error("No implementado");
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public final T getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public final void setModel(final T value) {
        this.model = value;
    }

    /**
     * Gets the result list.
     *
     * @return the result list
     */
    public final PaginatedList<R> getResultList() {
        return resultList;
    }

    /**
     * Sets the page.
     *
     * @param value
     *            the new page
     */
    public final void setPage(final int value) {
        this.page = value;
    }

    /**
     * Sets the limit.
     *
     * @param value
     *            the new limit
     */
    public final void setLimit(final int value) {
        this.limit = value;
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
