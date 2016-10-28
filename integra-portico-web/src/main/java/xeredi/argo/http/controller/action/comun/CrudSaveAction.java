package xeredi.argo.http.controller.action.comun;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudSaveAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class CrudSaveAction<T> extends BaseAction implements ProtectedAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6571569363320765658L;

    /** The accion. */
    @Getter
    @Setter
    protected AccionCodigo accion;

    /** The model. */
    @Getter
    @Setter
    protected T model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(model);

        if (model instanceof Versionable<?>) {
            Preconditions.checkNotNull(((Versionable<?>) model).getVersion());

            if (accion != AccionCodigo.create) {
                Preconditions.checkNotNull(((Versionable<?>) model).getVersion().getId());
            }
        }

        doValidate();

        if (!hasErrors()) {
            doSave();
        }
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
}
