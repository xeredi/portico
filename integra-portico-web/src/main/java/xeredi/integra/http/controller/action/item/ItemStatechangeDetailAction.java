package xeredi.integra.http.controller.action.item;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemTramiteVO;
import xeredi.integra.model.metamodelo.proxy.AbstractEntidadDetailVO;
import xeredi.integra.model.metamodelo.proxy.TramiteDetailVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemStatechangeDetailAction.
 *
 * @param <E>
 *            the element type
 * @param <IT>
 *            the generic type
 */
public abstract class ItemStatechangeDetailAction<E extends AbstractEntidadDetailVO, IT extends ItemTramiteVO> extends
BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4896160151140904396L;

    /** The trmt. */
    protected TramiteDetailVO trmt;

    /** The enti. */
    protected E enti;

    /** The ittr. */
    protected IT ittr;

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
    public final IT getIttr() {
        return ittr;
    }

    /**
     * Sets the ittr.
     *
     * @param ittr
     *            the new ittr
     */
    public final void setIttr(final IT ittr) {
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
}
