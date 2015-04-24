package xeredi.integra.http.controller.action.maestro;

import xeredi.integra.http.controller.action.item.ItemRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroVO;

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
        final SubparametroBO itemBO = new SubparametroBO();

        itemBO.delete(model);
    }
}