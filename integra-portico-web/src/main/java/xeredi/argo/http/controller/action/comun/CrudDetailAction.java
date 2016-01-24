package xeredi.argo.http.controller.action.comun;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.Versionable;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudDetailAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class CrudDetailAction<T> extends BaseAction implements ModelDriven<T>, ProtectedAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4674010824776069801L;

    /** The model. */
    @Getter
    @Setter
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

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getAccnCodigo() {
        return "detail";
    }
}
