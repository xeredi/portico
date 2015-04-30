package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionRemoveAction.
 */
public final class ValoracionRemoveAction extends CrudRemoveAction<ValoracionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -968075844003204369L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrcBO.delete(model.getId());
    }
}
