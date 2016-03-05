package xeredi.argo.http.controller.action.comun;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.exception.ApplicationException;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudLoadFileEditAction.
 *
 * @param <M>
 *            the generic type
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class CrudLoadPrepareAction<M> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7010746908649175923L;

    /** The model. */
    protected M model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        doPrepare();
    }

    /**
     * Do Prepare.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected abstract void doPrepare() throws ApplicationException;
}
