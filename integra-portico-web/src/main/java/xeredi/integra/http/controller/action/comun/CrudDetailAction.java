package xeredi.integra.http.controller.action.comun;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.Versionable;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudDetailAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class CrudDetailAction<T> extends BaseAction implements ModelDriven<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4674010824776069801L;

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
