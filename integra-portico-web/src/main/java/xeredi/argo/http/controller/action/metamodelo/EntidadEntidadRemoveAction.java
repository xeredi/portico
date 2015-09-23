package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.enen;
    }
}
