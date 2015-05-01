package xeredi.integra.http.controller.action.item;

import xeredi.integra.http.controller.action.comun.CrudChangeStateSaveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemChangeStateSaveAction.
 *
 * @param <M>
 *            the generic type
 */
public abstract class ItemChangeStateSaveAction<M extends ItemVO> extends CrudChangeStateSaveAction<M> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6605591299874680243L;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getEntiId());

        doSpecificValidate();
    }

    /**
     * Do specific validate.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public void doSpecificValidate() throws ApplicationException {
        // noop
    }
}
