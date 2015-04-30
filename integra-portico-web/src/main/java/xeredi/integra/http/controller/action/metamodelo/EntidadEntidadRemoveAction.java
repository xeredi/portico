package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadRemoveAction.
 */
public final class EntidadEntidadRemoveAction extends CrudRemoveAction<EntidadEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 422958063619937693L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiPadreId());
        Preconditions.checkNotNull(model.getEntiHija());
        Preconditions.checkNotNull(model.getEntiHija().getId());

        final EntidadEntidadBO enenBO = new EntidadEntidadBO();

        enenBO.delete(model);
    }
}
