package xeredi.integra.http.controller.action.servicio.manifiesto;

import xeredi.integra.http.controller.action.item.ItemChangeStateSaveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.BlBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class BlAnularAction.
 */
public final class BlAnularAction extends ItemChangeStateSaveAction<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6626268871152811483L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doChangeState() throws ApplicationException {
        final BlBO mablBO = new BlBO();

        mablBO.anular(model.getId());
    }
}
