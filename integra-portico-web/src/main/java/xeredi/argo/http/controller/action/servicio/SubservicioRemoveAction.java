package xeredi.argo.http.controller.action.servicio;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.service.SubservicioService;
import xeredi.argo.model.servicio.service.SubservicioServiceFactory;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioRemoveAction.
 */
public final class SubservicioRemoveAction extends ItemRemoveAction<SubservicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -281431600408668188L;

	@Inject
	private SubservicioServiceFactory ssrvFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getSrvc());
		Preconditions.checkNotNull(model.getSrvc().getId());

		final SubservicioService ssrvService = ssrvFactory.getInstance(model.getEntiId(), usroId);

		ssrvService.delete(model);
	}
}
