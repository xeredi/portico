package xeredi.integra.http.controller.action.item;

import xeredi.integra.http.controller.action.comun.TypeaheadAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemTypeahead;
import xeredi.integra.model.comun.vo.ItemVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTypeaheadAction.
 *
 * @param <C>
 *            the generic type
 * @param <R>
 *            the generic type
 */
public abstract class ItemTypeaheadAction<C extends ItemTypeahead, R extends ItemVO> extends TypeaheadAction<C, R> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 93542834789426243L;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doTypeahead() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getTextoBusqueda());

        model.setIdioma(idioma);

        doSpecificTypeahead();
    }

    /**
     * Do specific typeahead.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificTypeahead() throws ApplicationException;
}
