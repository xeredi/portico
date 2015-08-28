package xeredi.integra.http.controller.action.proceso;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCancelarAction.
 */
public final class ProcesoCancelarAction extends CrudRemoveAction<ProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3995570668859920070L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ProcesoBO prbtBO = new ProcesoBO();

        prbtBO.cancelar(model);
    }
}
