package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoRemoveAction.
 */
public final class CargoRemoveAction extends CrudRemoveAction<CargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6268936117161838481L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        final CargoBO crgoBO = new CargoBO();

        crgoBO.delete(model);
    }
}
