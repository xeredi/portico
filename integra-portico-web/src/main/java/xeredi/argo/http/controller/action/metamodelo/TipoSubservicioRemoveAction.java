package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioRemoveAction.
 */
public final class TipoSubservicioRemoveAction extends CrudRemoveAction<TipoSubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5990811920550460016L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final TipoSubservicioBO entiBO = new TipoSubservicioBO();

        entiBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpss;
    }

}
