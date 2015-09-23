package xeredi.argo.http.controller.action.comun;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class GridFilterAction.
 *
 * @param <C>
 *            the generic type
 */
public abstract class GridFilterAction<C extends BaseCriterioVO> extends BaseAction implements ModelDriven<C>,
        ProtectedAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -777906795137481254L;

    /** The valid rows per page. */
    public static final int[] VALID_ROWS_PER_PAGE = new int[] { 10, 20, 50, 100, 200, 500 };

    /** The model. */
    protected C model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        model.setIdioma(idioma);

        doPrepareFilter();
        doLoadDependencies();
    }

    /**
     * Do prepare filter.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doPrepareFilter() throws ApplicationException;

    /**
     * Do load dependencies.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doLoadDependencies() throws ApplicationException;

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
     * Gets the limits.
     *
     * @return the limits
     */
    public final int[] getLimits() {
        return VALID_ROWS_PER_PAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getAccnCodigo() {
        return "list";
    }

}
