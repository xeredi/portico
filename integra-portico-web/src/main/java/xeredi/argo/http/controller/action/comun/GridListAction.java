package xeredi.argo.http.controller.action.comun;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class GridListAction.
 *
 * @param <C>
 *            the generic type
 * @param <R>
 *            the generic type
 */
public abstract class GridListAction<C extends BaseCriterioVO, R> extends BaseAction implements ModelDriven<C> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6646875422640202469L;

    /** The rows per page default. */
    public static final int ROWS_PER_PAGE_DEFAULT = 20;

    /** The model. */
    protected C model;

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
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        model.setIdioma(idioma);

        doList();
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
    public final C getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public final void setModel(final C value) {
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
