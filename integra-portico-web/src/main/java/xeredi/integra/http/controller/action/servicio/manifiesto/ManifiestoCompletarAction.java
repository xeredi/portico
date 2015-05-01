package xeredi.integra.http.controller.action.servicio.manifiesto;

import xeredi.integra.http.controller.action.item.ItemChangeStateSaveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoCompletarAction.
 */
public final class ManifiestoCompletarAction extends ItemChangeStateSaveAction<ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6901530141749374393L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doChangeState() throws ApplicationException {
        final ManifiestoBO srvcBO = new ManifiestoBO();

        srvcBO.completar(model.getId());
    }
}
