package xeredi.integra.http.controller.action.administracion.puerto;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.bo.SuperpuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.SuperpuertoVO;

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
}
