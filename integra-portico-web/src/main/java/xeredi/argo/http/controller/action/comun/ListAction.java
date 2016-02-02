package xeredi.argo.http.controller.action.comun;

import java.util.List;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class ListAction.
 *
 * @param <R>
 *            the generic type
 */
public abstract class ListAction<R> extends BaseAction implements ProtectedAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6821401412110909190L;

    /** The result list. */
    @Getter
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
     * {@inheritDoc}
     */
    @Override
    public final AccionCodigo getAccion() {
        return AccionCodigo.list;
    }
}
