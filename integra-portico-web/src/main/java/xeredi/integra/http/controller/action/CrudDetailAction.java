package xeredi.integra.http.controller.action;

import xeredi.integra.model.comun.exception.ApplicationException;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudDetailAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class CrudDetailAction<T> extends BaseAction implements ModelDriven<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4674010824776069801L;

    /** The model. */
    protected T model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String execute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        doExecute();

        return SUCCESS;
    }

    /**
     * Do detail.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doExecute() throws ApplicationException;

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
