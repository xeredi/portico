package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.CrudEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaSerieBO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * Accion web de edición de una Serie de Factura.
 */
public final class FacturaSerieEditAction extends CrudEditAction<FacturaSerieVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3708189886402292349L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            model = new FacturaSerieVO();
        } else {
            Preconditions.checkNotNull(model.getId());

            final FacturaSerieBO fcsrBO = new FacturaSerieBO();

            model = fcsrBO.select(model.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
    }
}
