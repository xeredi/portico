package xeredi.argo.http.controller.action.administracion.puerto;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoRemoveAction.
 */
public final class PuertoRemoveAction extends CrudRemoveAction<PuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -635054006561119868L;

	@Inject
	private PuertoService prtoService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        prtoService.delete(model);
    }
}
