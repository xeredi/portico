package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.vo.ReglaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaRemoveAction.
 */
public final class ReglaRemoveAction extends CrudRemoveAction<ReglaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5160365319372545490L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ReglaBO rglaBO = new ReglaBO();

        rglaBO.delete(model);
    }
}
