package xeredi.argo.http.controller.action.comun;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class GridListAction.
 *
 * @param <C>
 *            the generic type
 * @param <R>
 *            the generic type
 */
public abstract class GridListAction<C extends BaseCriterioVO, R> extends BaseAction implements ModelDriven<C>,
        ProtectedAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6646875422640202469L;

    /** The rows per page default. */
    public static final int ROWS_PER_PAGE_DEFAULT = 20;

    /** The model. */
    @Getter
    @Setter
    protected C model;

    /** The result list. */
    @Getter
    protected PaginatedList<R> resultList;

    /** The page. */
    @Getter
    @Setter
    protected int page = PaginatedList.FIRST_PAGE;

    /** The limit. */
    @Setter
    protected int limit = ROWS_PER_PAGE_DEFAULT;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkArgument(page > 0);
        Preconditions.checkArgument(limit > 0);

        model.setIdioma(getIdioma());

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
     * Gets the offset.
     *
     * @return the offset
     */
    protected final int getOffset() {
        return (page - PaginatedList.FIRST_PAGE) * limit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final AccionCodigo getAccion() {
        return AccionCodigo.list;
    }
}
