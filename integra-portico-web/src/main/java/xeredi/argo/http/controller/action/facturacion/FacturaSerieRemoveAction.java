package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaSerieBO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * Accion Web de borrado de una Serie de Factura.
 */
public final class FacturaSerieRemoveAction extends CrudRemoveAction<FacturaSerieVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5331771894462064607L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final FacturaSerieBO fcsrBO = new FacturaSerieBO();

        fcsrBO.delete(model);
    }
}
