package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.CrudSaveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleSaveAction.
 */
public final class ValoracionDetalleSaveAction extends CrudSaveAction<ValoracionDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1354136282476244950L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final ValoracionBO vlrcBO = new ValoracionBO();

        switch (accion) {
        case create:
            vlrcBO.insertVlrd(model);

            break;
        case edit:
            vlrcBO.updateVlrd(model);

            break;
        default:
            throw new Error("Accion no valida: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getVlrcId());
        Preconditions.checkNotNull(model.getVlrlId());

        if (ACCION_EDICION.edit == accion) {
            Preconditions.checkNotNull(model.getId());
        }
    }
}
