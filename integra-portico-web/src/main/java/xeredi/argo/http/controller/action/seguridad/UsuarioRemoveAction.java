package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.UsuarioBO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioRemoveAction.
 */
public final class UsuarioRemoveAction extends CrudRemoveAction<UsuarioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5018891561096266090L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final UsuarioBO usroBO = new UsuarioBO();

        usroBO.delete(model);
    }

}
