package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.trmt;
    }
}
