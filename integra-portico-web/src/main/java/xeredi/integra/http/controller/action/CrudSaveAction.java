package xeredi.integra.http.controller.action;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.Versionable;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudSaveAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class CrudSaveAction<T> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6571569363320765658L;

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
        Preconditions.checkNotNull(model);

        if (model instanceof Versionable<?>) {
            Preconditions.checkNotNull(((Versionable<?>) model).getVersion());

            if (accion != ACCION_EDICION.create) {
                Preconditions.checkNotNull(((Versionable<?>) model).getVersion().getId());
            }
        }

        doValidate();

        if (hasErrors()) {
            return SUCCESS;
        }

        doSave();

        return SUCCESS;
    }

    /**
     * Do execute.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSave() throws ApplicationException;

    /**
     * Do validate.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doValidate() throws ApplicationException;

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
     * Gets the model.
     *
     * @return the model
     */
    public T getModel() {
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
