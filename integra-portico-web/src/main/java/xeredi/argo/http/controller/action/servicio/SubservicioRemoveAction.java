package xeredi.argo.http.controller.action.servicio;

import xeredi.argo.http.controller.action.item.ItemRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
import xeredi.argo.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioRemoveAction.
 */
public final class SubservicioRemoveAction extends ItemRemoveAction<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -281431600408668188L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getSrvc());
        Preconditions.checkNotNull(model.getSrvc().getId());

        final SubservicioBO itemBO = SubservicioBOFactory.newInstance(model.getEntiId());

        itemBO.delete(model);
    }
}
