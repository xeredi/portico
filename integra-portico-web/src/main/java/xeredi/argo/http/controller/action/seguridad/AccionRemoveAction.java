package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.vo.AccionVO;

import com.google.common.base.Preconditions;

/**
 * The Class AccionRemoveAction.
 */
public final class AccionRemoveAction extends CrudRemoveAction<AccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 353308355649870324L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionBO accnBO = new AccionBO();

        accnBO.delete(model);
    }
}
