package xeredi.integra.http.controller.action.comun;

import xeredi.integra.model.comun.exception.ApplicationException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudChangeStateAction.
 *
 * @param <M>
 *            the generic type
 */
public abstract class CrudChangeStateSaveAction<M> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6926634950708317639L;

    /** The model. */
    protected M model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        doValidate();

        if (!hasErrors()) {
            doChangeState();
        }
    }

    /**
     * Do change state.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doChangeState() throws ApplicationException;

    /**
     * Do validate.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doValidate() throws ApplicationException;

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public final void setModel(final M value) {
        this.model = value;
    }
}
