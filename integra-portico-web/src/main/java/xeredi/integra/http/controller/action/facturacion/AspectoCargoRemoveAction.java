package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoCargoBO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoRemoveAction.
 */
public final class AspectoCargoRemoveAction extends CrudRemoveAction<AspectoCargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8982657228033763093L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        final AspectoCargoBO ascrBO = new AspectoCargoBO();

        ascrBO.delete(model);
    }
}
