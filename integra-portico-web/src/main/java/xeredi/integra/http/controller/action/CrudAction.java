package xeredi.integra.http.controller.action;

import xeredi.integra.model.comun.exception.ApplicationException;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class CrudAction<T> extends BaseAction implements ModelDriven<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2425603703769506676L;

    /** The accion. */
    protected ACCION_EDICION accion;

    /** The model. */
    protected T model;

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    public final String edit() throws ApplicationException {
        Preconditions.checkNotNull(accion);

        doEdit();

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    public final String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);

        doSave();

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    public final String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);

        doRemove();

        return SUCCESS;
    }

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    public final String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);

        doDetail();

        return SUCCESS;
    }

    /**
     * Do edit.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected void doEdit() throws ApplicationException {
        throw new Error("No implementado");
    }

    /**
     * Do save.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected void doSave() throws ApplicationException {
        throw new Error("No implementado");
    }

    /**
     * Do remove.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected void doRemove() throws ApplicationException {
        throw new Error("No implementado");
    }

    /**
     * Do detail.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected void doDetail() throws ApplicationException {
        throw new Error("No implementado");
    }

    /**
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public final void setAccion(final ACCION_EDICION value) {
        accion = value;
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
