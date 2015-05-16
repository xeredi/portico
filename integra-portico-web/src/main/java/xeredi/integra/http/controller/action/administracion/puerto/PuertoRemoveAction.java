package xeredi.integra.http.controller.action.administracion.puerto;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.PuertoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoRemoveAction.
 */
public final class PuertoRemoveAction extends CrudRemoveAction<PuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -635054006561119868L;

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
