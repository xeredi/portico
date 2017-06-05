package xeredi.argo.http.controller.action.servicio;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.service.ServicioService;
import xeredi.argo.model.servicio.service.ServicioServiceFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioRemoveAction.
 */
public final class ServicioRemoveAction extends ItemRemoveAction<ServicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3971527637136301731L;

	/** The srvc factory. */
	@Inject
	private ServicioServiceFactory srvcFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificRemove() throws ApplicationException {
		final ServicioService srvcService = srvcFactory.getInstance(model.getEntiId(), usroId);

		srvcService.delete(model);
	}
}
