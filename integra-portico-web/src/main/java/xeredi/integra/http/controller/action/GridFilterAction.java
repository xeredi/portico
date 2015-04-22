package xeredi.integra.http.controller.action;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.BaseCriterioVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class GridFilterAction.
 *
 * @param <C>
 *            the generic type
 */
public abstract class GridFilterAction<C extends BaseCriterioVO> extends BaseAction implements ModelDriven<C> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -777906795137481254L;

    /** The model. */
    protected C model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String execute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        model.setIdioma(idioma);

        doPrepareFilter();
        doLoadDependencies();

        return SUCCESS;
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

}
