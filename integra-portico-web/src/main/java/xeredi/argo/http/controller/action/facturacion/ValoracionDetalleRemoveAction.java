package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.facturacion.bo.ValoracionDetalleBO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleRemoveAction.
 */
@Data
public final class ValoracionDetalleRemoveAction extends CrudRemoveAction<ValoracionDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1970434275265288322L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.vlrd;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getVlrlId());

        final ValoracionDetalleBO vlrdBO = new ValoracionDetalleBO();

        vlrdBO.delete(model);
    }
}
