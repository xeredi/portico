package xeredi.integra.http.controller.action;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.BaseCriterioVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class GridListAction.
 *
 * @param <T>
 *            the generic type
 * @param <R>
 *            the generic type
 */
public abstract class GridListAction<T extends BaseCriterioVO, R> extends BaseAction implements ModelDriven<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6646875422640202469L;

    /** The rows per page default. */
    public static final int ROWS_PER_PAGE_DEFAULT = 20;

    /** The model. */
    protected T model;

    /** The result list. */
    protected PaginatedList<R> resultList;

    /** The page. */
    protected int page = PaginatedList.FIRST_PAGE;

    /** The limit. */
    protected int limit = ROWS_PER_PAGE_DEFAULT;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String execute() throws ApplicationException {
        model.setIdioma(idioma);

        doList();

        return SUCCESS;
    }

    /**
     * Do execute.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doList() throws ApplicationException;

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
        page = value;
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
    protected final int getOffset() {
        return (page - PaginatedList.FIRST_PAGE) * limit;
    }

}
