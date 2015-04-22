package xeredi.integra.http.controller.action.item;

import xeredi.integra.http.controller.action.CrudSaveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemSaveAction.
 *
 * @param <I>
 *            the generic type
 */
public abstract class ItemSaveAction<I extends ItemVO> extends CrudSaveAction<I> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8814260021956629985L;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getId());
        }

        doSpecificValidate();
    }

    /**
     * Do specific validate.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificValidate() throws ApplicationException;
}
