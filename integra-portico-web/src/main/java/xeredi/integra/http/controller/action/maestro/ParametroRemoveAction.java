package xeredi.integra.http.controller.action.maestro;

import xeredi.integra.http.controller.action.item.ItemRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroVO;

import com.google.common.base.Preconditions;

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
        Preconditions.checkNotNull(model.getPrvr());
        Preconditions.checkNotNull(model.getPrvr().getFini());

        final ParametroBO itemBO = ParametroBOFactory.newInstance(model.getEntiId());

        itemBO.delete(model);
    }
}
