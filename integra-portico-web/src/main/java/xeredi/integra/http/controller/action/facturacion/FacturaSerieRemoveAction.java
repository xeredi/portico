package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaSerieBO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;

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

        fcsrBO.delete(model.getId());
    }
}
