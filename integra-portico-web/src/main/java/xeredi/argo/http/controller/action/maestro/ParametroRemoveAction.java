package xeredi.argo.http.controller.action.maestro;

import xeredi.argo.http.controller.action.item.ItemRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroRemoveAction.
 */
public final class ParametroRemoveAction extends ItemRemoveAction<ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8920405603047117674L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificRemove() throws ApplicationException {
        final ParametroBO itemBO = ParametroBOFactory.newInstance(model.getEntiId());

        itemBO.delete(model);
    }
}
