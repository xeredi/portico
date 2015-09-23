package xeredi.argo.http.controller.action.item;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemRemoveAction.
 *
 * @param <I>
 *            the generic type
 */
public abstract class ItemRemoveAction<I extends ItemVO> extends CrudRemoveAction<I> implements ProtectedItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6012777404694278177L;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getEntiId());

        doSpecificRemove();
    }

    /**
     * Do specific remove.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificRemove() throws ApplicationException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final Long getEntiId() {
        return model.getEntiId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final AccionPrefix getAccnPrefix() {
        return AccionPrefix.item;
    }
}
