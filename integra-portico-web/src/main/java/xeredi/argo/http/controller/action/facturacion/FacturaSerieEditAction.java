package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaSerieBO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * Accion web de edición de una Serie de Factura.
 */
@Data
public final class FacturaSerieEditAction extends CrudEditAction<FacturaSerieVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3708189886402292349L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
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
