package xeredi.integra.http.controller.action;

import xeredi.integra.model.comun.exception.ApplicationException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudRemoveAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class CrudRemoveAction<T> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8487722303118008776L;

    /** The model. */
    protected T model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String execute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        doRemove();

        return SUCCESS;
    }

    /**
     * Do execute.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doRemove() throws ApplicationException;

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
