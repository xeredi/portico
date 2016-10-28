package xeredi.argo.http.controller.action.facturacion;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.vo.CargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoRemoveAction.
 */
@Data
public final class CargoRemoveAction extends CrudRemoveAction<CargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6268936117161838481L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.crgo;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        final CargoBO crgoBO = new CargoBO();

        crgoBO.delete(model);
    }
}
