package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaSerieBO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * Acción de visualización de una Serie de Factura.
 */
public final class FacturaSerieDetailAction extends CrudDetailAction<FacturaSerieVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3073491306925702540L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final FacturaSerieBO fcsrBO = new FacturaSerieBO();

        model = fcsrBO.select(model.getId());
    }
}
