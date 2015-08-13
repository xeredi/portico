package xeredi.integra.http.controller.action.item;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.item.vo.ItemTramiteVO;
import xeredi.integra.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.integra.model.metamodelo.vo.TramiteDetailVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemStatechangeDetailAction.
 *
 * @param <I>
 *            the generic type
 * @param <E>
 *            the element type
 */
public abstract class ItemStatechangeDetailAction<I extends ItemVO, E extends AbstractEntidadDetailVO> extends
        BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4896160151140904396L;

    /** The trmt. */
    protected TramiteDetailVO trmt;

    /** The enti. */
    protected E enti;

    /** The item. */
    protected I item;

    /** The ittr. */
    protected ItemTramiteVO ittr;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(ittr);
        Preconditions.checkNotNull(ittr.getId());

        doDetail();
    }

    /**
     * Do detail.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected abstract void doDetail() throws ApplicationException;

    /**
     * Gets the ittr.
     *
     * @return the ittr
     */
    public final ItemTramiteVO getIttr() {
        return ittr;
    }

    /**
     * Sets the ittr.
     *
     * @param ittr
     *            the new ittr
     */
    public final void setIttr(final ItemTramiteVO ittr) {
        this.ittr = ittr;
    }

    /**
     * Gets the trmt.
     *
     * @return the trmt
     */
    public final TramiteDetailVO getTrmt() {
        return trmt;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public final E getEnti() {
        return enti;
    }

    /**
     * Gets the item.
     *
     * @return the item
     */
    public final I getItem() {
        return item;
    }
}
