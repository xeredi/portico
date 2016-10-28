package xeredi.argo.http.controller.action.administracion.puerto;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoRemoveAction.
 */
@Data
public final class PuertoRemoveAction extends CrudRemoveAction<PuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -635054006561119868L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.prto;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final PuertoBO prtoBO = new PuertoBO();

        prtoBO.delete(model);
    }
}
