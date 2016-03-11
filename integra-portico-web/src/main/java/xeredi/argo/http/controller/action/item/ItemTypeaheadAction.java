package xeredi.argo.http.controller.action.item;

import xeredi.argo.http.controller.action.comun.TypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.vo.ItemTypeahead;
import xeredi.argo.model.item.vo.ItemVO;

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
