package xeredi.integra.http.controller.action.servicio.manifiesto;

import xeredi.integra.http.controller.action.item.ItemChangeStateSaveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoAnularAction.
 */
public final class ManifiestoAnularAction extends ItemChangeStateSaveAction<ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8648327579317909228L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doChangeState() throws ApplicationException {
        final ManifiestoBO srvcBO = new ManifiestoBO();

        srvcBO.anular(model.getId());
    }
}
