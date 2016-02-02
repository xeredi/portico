package xeredi.argo.http.controller.action.comun;

import lombok.Setter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.seguridad.vo.AccionCodigo;

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
    @Setter
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
     * {@inheritDoc}
     */
    @Override
    public AccionCodigo getAccion() {
        return AccionCodigo.remove;
    }

}
