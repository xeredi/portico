package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.vo.FacturaDetalleVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetalleDetailAction.
 */
public final class FacturaDetalleDetailAction extends CrudDetailAction<FacturaDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5723011920089830401L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final FacturaBO fctdBO = new FacturaBO();

        model = fctdBO.selectFctd(model.getId(), getIdioma());
    }
}
