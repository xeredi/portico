package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.facturacion.bo.FacturaSerieBO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;

// TODO: Auto-generated Javadoc
/**
 * Acción de visualización de una Serie de Factura.
 */
@Data
public final class FacturaSerieDetailAction extends CrudDetailAction<FacturaSerieVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3073491306925702540L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.fcsr;

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
