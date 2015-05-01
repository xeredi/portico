package xeredi.integra.http.controller.action.comun;

import xeredi.integra.model.comun.exception.ApplicationException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudChangeStateEditAction.
 *
 * @param <M>
 *            the generic type
 */
public abstract class CrudChangeStateEditAction<M> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2781898367095835833L;

    /** The model. */
    protected M model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        doEdit();

        if (!hasErrors()) {
            doLoadDependencies();
        }
    }

    /**
     * Do edit.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doEdit() throws ApplicationException;

    /**
     * Do load dependencies.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doLoadDependencies() throws ApplicationException;

    /**
     * Gets the model.
     *
     * @return the model
     */
    public final M getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the new model
     */
    public final void setModel(final M model) {
        this.model = model;
    }
}
