package xeredi.argo.http.controller.action.item;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemSaveAction.
 *
 * @param <I>
 *            the generic type
 */
@Data
public abstract class ItemSaveAction<I extends ItemVO> extends CrudSaveAction<I> implements ProtectedItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8814260021956629985L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.item;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        if (accion != AccionCodigo.create) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public final Long getEntiId() {
        return model.getEntiId();
    }
}
