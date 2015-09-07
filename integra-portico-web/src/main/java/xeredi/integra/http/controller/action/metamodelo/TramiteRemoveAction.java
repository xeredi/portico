package xeredi.integra.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TramiteBO;
import xeredi.integra.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteRmoveAction.
 */
public final class TramiteRemoveAction extends CrudRemoveAction<TramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8053448630800994429L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final TramiteBO trmtBO = new TramiteBO();

        trmtBO.delete(model);
    }
}
