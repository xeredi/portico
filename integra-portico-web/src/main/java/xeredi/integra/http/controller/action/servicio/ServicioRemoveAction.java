package xeredi.integra.http.controller.action.servicio;

import xeredi.integra.http.controller.action.item.ItemRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioVO;

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
        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

        srvcBO.delete(model.getId());
    }
}
