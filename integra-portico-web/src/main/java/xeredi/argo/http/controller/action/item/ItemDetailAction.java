package xeredi.argo.http.controller.action.item;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemDetailAction.
 *
 * @param <I>
 *            the generic type
 * @param <E>
 *            the element type
 */
@Data
public abstract class ItemDetailAction<I extends ItemVO, E extends AbstractEntidadDetailVO> extends CrudDetailAction<I>
        implements ProtectedItemAction {

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
     * {@inheritDoc}
     */
    @Override
    public final Long getEntiId() {
        return model.getEntiId();
    }
}
