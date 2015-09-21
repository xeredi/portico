package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaRemoveAction.
 */
public final class ValoracionLineaRemoveAction extends CrudRemoveAction<ValoracionLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -600415209403363458L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getVlrcId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrcBO.deleteVlrl(model);
    }
}
