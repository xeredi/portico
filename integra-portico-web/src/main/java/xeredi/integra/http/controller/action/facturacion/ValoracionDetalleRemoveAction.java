package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleRemoveAction.
 */
public final class ValoracionDetalleRemoveAction extends CrudRemoveAction<ValoracionDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1970434275265288322L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getVlrlId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrcBO.deleteVlrd(model);
    }
}
