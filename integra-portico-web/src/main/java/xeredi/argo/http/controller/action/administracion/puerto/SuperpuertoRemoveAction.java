package xeredi.argo.http.controller.action.administracion.puerto;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoRemoveAction.
 */
public final class SuperpuertoRemoveAction extends CrudRemoveAction<SuperpuertoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5538518756987245961L;

	@Inject
	private SuperpuertoService sprtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		sprtService.delete(model);
	}
}
