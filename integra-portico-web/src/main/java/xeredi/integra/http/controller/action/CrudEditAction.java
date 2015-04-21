package xeredi.integra.http.controller.action;

import xeredi.integra.model.comun.exception.ApplicationException;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudEditAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class CrudEditAction<T> extends BaseAction implements ModelDriven<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7147721554331909672L;

    /** The accion. */
    protected ACCION_EDICION accion;

    /** The model. */
    protected T model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String execute() throws ApplicationException {
        Preconditions.checkNotNull(accion);

        doEdit();

        if (!hasErrors()) {
            doLoadDependencies();
        }

        return SUCCESS;
    }

    /**
     * Do execute.
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
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public final void setAccion(final ACCION_EDICION value) {
        this.accion = value;
    }

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