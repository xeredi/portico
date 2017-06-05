package xeredi.argo.http.controller.action.servicio;

import java.util.Calendar;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.service.ServicioService;
import xeredi.argo.model.servicio.service.ServicioServiceFactory;
import xeredi.argo.model.servicio.service.SubservicioService;
import xeredi.argo.model.servicio.service.SubservicioServiceFactory;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioEditAction.
 */
public final class SubservicioEditAction extends ItemEditAction<SubservicioVO, TipoSubservicioDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3286199992331373729L;

	/** The srvc factory. */
	@Inject
	private ServicioServiceFactory srvcFactory;

	@Inject
	private SubservicioServiceFactory ssrvFactory;

	/** The enti proxy. */
	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificEdit() throws ApplicationException {
		enti = entiProxy.selectTpss(model.getEntiId());

		switch (accion) {
		case create:
			if (model.getSrvc() != null && model.getSrvc().getId() != null) {
				final ServicioService srvcService = srvcFactory.getInstance(enti.getEnti().getTpsrId(), usroId);

				model.setSrvc(srvcService.select(model.getSrvc().getId(), getIdioma()));
				model.setFref(model.getSrvc().getFref());

				// Si viene de un subservicio padre, lo buscamos
				for (final Long entiId : model.getSsrvPadreMap().keySet()) {
					final SubservicioService ssrvPadreService = ssrvFactory.getInstance(entiId, usroId);

					model.getSsrvPadreMap().put(entiId,
							ssrvPadreService.select(model.getSsrvPadreMap().get(entiId).getId(), getIdioma()));
				}
			} else {
				model.setFref(Calendar.getInstance().getTime());
			}

			model.setEstado(enti.getEnti().getEstadoDef());

			break;
		case edit:
		case duplicate:
			final SubservicioService ssrvService = ssrvFactory.getInstance(model.getEntiId(), usroId);

			Preconditions.checkNotNull(model.getSrvc());
			Preconditions.checkNotNull(model.getSrvc().getId());

			model = ssrvService.select(model.getId(), getIdioma());

			break;
		default:
			throw new Error("Invalid action: " + accion.name());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadSpecificDependencies() throws ApplicationException {
		// noop
	}
}
