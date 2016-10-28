package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.aspc;
    }
}
