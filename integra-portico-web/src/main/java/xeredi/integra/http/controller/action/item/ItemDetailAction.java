package xeredi.integra.http.controller.action.item;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.item.vo.ItemVO;
import xeredi.integra.model.metamodelo.vo.AbstractEntidadDetailVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemDetailAction.
 *
 * @param <I>
 *            the generic type
 * @param <E>
 *            the element type
 */
public abstract class ItemDetailAction<I extends ItemVO, E extends AbstractEntidadDetailVO> extends CrudDetailAction<I> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5159354861110927934L;

    /** The enti. */
    protected E enti;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getEntiId());

        doSpecificDetail();
    }

    /**
     * Do specific detail.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificDetail() throws ApplicationException;

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public final E getEnti() {
        return enti;
    }
}
