package xeredi.argo.http.controller.action.administracion.puerto;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoRemoveAction.
 */
@Data
public final class SuperpuertoRemoveAction extends CrudRemoveAction<SuperpuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5538518756987245961L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.sprt;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();

        sprtBO.delete(model);
    }
}
