package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionRemoveAction.
 */
public final class ValoracionRemoveAction extends CrudRemoveAction<ValoracionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -968075844003204369L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrcBO.delete(model.getId());
    }
}
