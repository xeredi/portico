package xeredi.integra.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleVO;

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
