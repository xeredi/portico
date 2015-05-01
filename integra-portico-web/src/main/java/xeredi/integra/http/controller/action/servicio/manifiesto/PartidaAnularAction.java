package xeredi.integra.http.controller.action.servicio.manifiesto;

import xeredi.integra.http.controller.action.item.ItemChangeStateSaveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.PartidaBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidaAnularAction.
 */
public final class PartidaAnularAction extends ItemChangeStateSaveAction<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7724380073007028226L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doChangeState() throws ApplicationException {
        final PartidaBO partBO = new PartidaBO();

        partBO.anular(model.getId());
    }
}
