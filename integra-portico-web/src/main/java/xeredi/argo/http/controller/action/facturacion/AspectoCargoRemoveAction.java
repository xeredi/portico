package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoCargoBO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.ascr;
    }
}
