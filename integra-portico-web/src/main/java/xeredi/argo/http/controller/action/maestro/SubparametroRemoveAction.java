package xeredi.argo.http.controller.action.maestro;

import xeredi.argo.http.controller.action.item.ItemRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.bo.SubparametroBO;
import xeredi.argo.model.maestro.bo.SubparametroBOFactory;
import xeredi.argo.model.maestro.vo.SubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * Accion web de borrado de un Submaestro.
 */
public final class SubparametroRemoveAction extends ItemRemoveAction<SubparametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1199133414671472814L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificRemove() throws ApplicationException {
        final SubparametroBO itemBO = SubparametroBOFactory.newInstance(model.getEntiId());

        itemBO.delete(model);
    }
}
