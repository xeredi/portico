package xeredi.integra.http.controller.action;

import java.util.List;

import xeredi.integra.model.comun.exception.ApplicationException;

// TODO: Auto-generated Javadoc
/**
 * The Class ListAction.
 *
 * @param <R>
 *            the generic type
 */
public abstract class ListAction<R> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6821401412110909190L;

    /** The result list. */
    protected List<R> resultList;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        doList();
    }

    /**
     * Do list.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doList() throws ApplicationException;

    /**
     * Gets the result list.
     *
     * @return the result list
     */
    public final List<R> getResultList() {
        return resultList;
    }
}
