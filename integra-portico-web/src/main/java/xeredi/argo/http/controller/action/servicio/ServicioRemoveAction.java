package xeredi.argo.http.controller.action.servicio;

import xeredi.argo.http.controller.action.item.ItemRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioRemoveAction.
 */
public final class ServicioRemoveAction extends ItemRemoveAction<ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3971527637136301731L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificRemove() throws ApplicationException {
        final ServicioBO itemBO = ServicioBOFactory.newInstance(model.getEntiId(), usroId);

        itemBO.delete(model);
    }
}
