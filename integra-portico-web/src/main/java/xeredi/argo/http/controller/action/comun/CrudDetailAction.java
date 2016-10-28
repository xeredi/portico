package xeredi.argo.http.controller.action.comun;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

import lombok.Data;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudDetailAction.
 *
 * @param <T>
 *            the generic type
 */
@Data
public abstract class CrudDetailAction<T> extends BaseAction implements ModelDriven<T>, ProtectedAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4674010824776069801L;

    /** The accion. */
    private final AccionCodigo accion = AccionCodigo.detail;

    /** The model. */
    protected T model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        if (model instanceof Versionable<?>) {
            Preconditions.checkNotNull(((Versionable<?>) model).getFref());
        }

        doDetail();
    }

    /**
     * Do detail.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doDetail() throws ApplicationException;
}
