package xeredi.argo.http.controller.action.comun;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.Versionable;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudRemoveAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class CrudRemoveAction<T> extends BaseAction implements ProtectedAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8487722303118008776L;

    /** The model. */
    protected T model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        if (model instanceof Versionable<?>) {
            Preconditions.checkNotNull(((Versionable<?>) model).getVersion());
            Preconditions.checkNotNull(((Versionable<?>) model).getVersion().getId());
        }

        doRemove();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAccnCodigo() {
        return "remove";
    }

}
