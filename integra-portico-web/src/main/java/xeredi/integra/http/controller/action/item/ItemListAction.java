package xeredi.integra.http.controller.action.item;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemCriterioVO;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.metamodelo.vo.AbstractEntidadDetailVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemListAction.
 *
 * @param <C>
 *            the generic type
 * @param <I>
 *            the generic type
 * @param <E>
 *            the element type
 */
public abstract class ItemListAction<C extends ItemCriterioVO, I extends ItemVO, E extends AbstractEntidadDetailVO>
extends GridListAction<C, I> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1634381107882001806L;

    /** The enti. */
    protected E enti;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doList() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        model.setSoloDatosGrid(true);
        model.setIdioma(idioma);

        doSpecificList();
    }

    /**
     * Do specific list.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificList() throws ApplicationException;

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public final E getEnti() {
        return enti;
    }

}
