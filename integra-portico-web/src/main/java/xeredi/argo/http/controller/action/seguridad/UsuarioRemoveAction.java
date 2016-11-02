package xeredi.argo.http.controller.action.seguridad;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.UsuarioBO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioRemoveAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
