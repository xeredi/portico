package xeredi.argo.http.controller.action.comun;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudEditAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class CrudEditAction<T> extends BaseAction implements ModelDriven<T>, ProtectedAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7147721554331909672L;

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

        if (accion == AccionCodigo.edit || accion == AccionCodigo.duplicate) {
            if (model instanceof Versionable<?>) {
                Preconditions.checkNotNull(((Versionable<?>) model).getFref());
            }
        } else {
            if (model instanceof Versionable<?> && ((Versionable<?>) model).getFref() == null) {
                ((Versionable<?>) model).setFref(Calendar.getInstance().getTime());
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
}
