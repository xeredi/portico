package xeredi.argo.http.controller.action.maestro.amarredeportivo;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.service.embdeportivas.AmarreDeportivoService;

// TODO: Auto-generated Javadoc
/**
 * The Class EmbDepAutListadoAction.
 */
public final class RecalcularEstadoAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1922904918711479468L;

	/** The amad service. */
	@Inject
	private AmarreDeportivoService amadService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExecute() throws ApplicationException {
		amadService.updateRecalcularEstado();
	}
}
