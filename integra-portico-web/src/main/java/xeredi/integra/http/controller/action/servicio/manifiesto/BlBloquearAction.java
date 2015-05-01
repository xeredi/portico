package xeredi.integra.http.controller.action.servicio.manifiesto;

import xeredi.integra.http.controller.action.comun.CrudChangeStateAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.BlBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class BlBloquearAction.
 */
public final class BlBloquearAction extends CrudChangeStateAction<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4366670124306392714L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doChangeState() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final BlBO mablBO = new BlBO();

        mablBO.bloquear(model.getId());
    }
}
