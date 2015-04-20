package xeredi.integra.http.controller.action;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.BaseCriterioVO;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class GridFilterAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class GridFilterAction<T extends BaseCriterioVO> extends BaseAction implements ModelDriven<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -777906795137481254L;

    /** The model. */
    protected T model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String execute() throws ApplicationException {
        model.setIdioma(idioma);

        doPrepareFilter();

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

}
