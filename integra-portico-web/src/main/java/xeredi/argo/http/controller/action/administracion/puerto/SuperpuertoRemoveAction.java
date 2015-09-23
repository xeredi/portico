package xeredi.argo.http.controller.action.administracion.puerto;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoRemoveAction.
 */
public final class SuperpuertoRemoveAction extends CrudRemoveAction<SuperpuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5538518756987245961L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();

        sprtBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.sprt;
    }
}
