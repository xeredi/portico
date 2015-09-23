package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.vlrd;
    }
}
