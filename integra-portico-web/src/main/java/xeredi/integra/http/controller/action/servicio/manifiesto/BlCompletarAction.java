package xeredi.integra.http.controller.action.servicio.manifiesto;

import xeredi.integra.http.controller.action.item.ItemChangeStateSaveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.BlBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class BlCompletarAction.
 */
public final class BlCompletarAction extends ItemChangeStateSaveAction<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2554813101217958890L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doChangeState() throws ApplicationException {
        final BlBO mablBO = new BlBO();

        mablBO.completar(model.getId());
    }
}
