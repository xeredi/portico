package xeredi.integra.http.controller.action.item;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemTramiteVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemStatechangeSaveAction.
 *
 * @param <IT>
 *            the generic type
 */
public abstract class ItemStatechangeSaveAction<IT extends ItemTramiteVO> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 515757187193538696L;

    /** The item. */
    protected IT ittr;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(ittr);
        Preconditions.checkNotNull(ittr.getTrmt());
        Preconditions.checkNotNull(ittr.getTrmt().getId());
        Preconditions.checkNotNull(ittr.getTrmt().getEntiId());

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
     * Sets the ittr.
     *
     * @param value
     *            the new ittr
     */
    public final void setIttr(final IT value) {
        this.ittr = value;
    }

}
