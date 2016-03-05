package xeredi.argo.http.controller.action.servicio;

import xeredi.argo.http.controller.action.comun.CrudLoadPrepareAction;
import xeredi.argo.http.view.servicio.ProcesoServicioVO;
import xeredi.argo.model.comun.exception.ApplicationException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioLoadPrepareAction.
 */
public final class ServicioLoadPrepareAction extends CrudLoadPrepareAction<ProcesoServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5933711398097207511L;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doPrepare() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
    }
}
