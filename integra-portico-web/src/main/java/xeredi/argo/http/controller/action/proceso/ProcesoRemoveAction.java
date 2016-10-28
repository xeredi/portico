package xeredi.argo.http.controller.action.proceso;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCancelarAction.
 */
@Data
public final class ProcesoRemoveAction extends CrudRemoveAction<ProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3995570668859920070L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.prbt;

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
