package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.CampoAgregacionBO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAggregacionRemoveAction.
 */
public final class CampoAgregacionRemoveAction extends CrudRemoveAction<CampoAgregacionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8109677827127703539L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getTpesId());
        Preconditions.checkNotNull(model.getEntd());
        Preconditions.checkNotNull(model.getEntd().getId());

        final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

        cmagBO.delete(model);
    }
}
