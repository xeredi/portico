package xeredi.integra.http.controller.action.item;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemStatechangeSaveAction.
 *
 * @param <I>
 *            the generic type
 */
public abstract class ItemStatechangeSaveAction<I extends ItemVO> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 515757187193538696L;

    /** The item. */
    protected I item;

    /** The trmt id. */
    protected Long trmtId;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(trmtId);
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getEntiId());

        doValidate();

        if (!hasErrors()) {
            doStatechangeSave();
        }
    }

    /**
     * Do validate.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doValidate() throws ApplicationException;

    /**
     * Do statechange save.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doStatechangeSave() throws ApplicationException;

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public final void setItem(final I value) {
        this.item = value;
    }

    /**
     * Sets the trmt id.
     *
     * @param value
     *            the new trmt id
     */
    public final void setTrmtId(final Long value) {
        this.trmtId = value;
    }
}
