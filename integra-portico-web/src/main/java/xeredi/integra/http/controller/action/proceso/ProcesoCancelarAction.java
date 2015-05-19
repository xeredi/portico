package xeredi.integra.http.controller.action.proceso;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCancelarAction.
 */
public final class ProcesoCancelarAction extends CrudChangeStateSaveAction<ProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3995570668859920070L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doChangeState() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ProcesoBO prbtBO = new ProcesoBO();

        prbtBO.cancelar(model);
    }
}
