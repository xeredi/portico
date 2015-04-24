package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoRemoveAction.
 */
public final class AspectoRemoveAction extends CrudRemoveAction<AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2102022344017937240L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        final AspectoBO aspcBO = new AspectoBO();

        aspcBO.delete(model);
    }
}