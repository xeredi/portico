package xeredi.integra.http.controller.action.comun;

import java.util.Date;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.Versionable;

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

    /** The fecha vigencia. */
    protected Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(accion);

        if (model instanceof Versionable<?>) {
            if (accion == ACCION_EDICION.edit || accion == ACCION_EDICION.duplicate) {
                Preconditions.checkNotNull(fechaVigencia);
            }
        }

        doEdit();

        if (!hasErrors()) {
            doLoadDependencies();
        }
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

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public final Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public final void setFechaVigencia(final Date value) {
        this.fechaVigencia = value;
    }
}
