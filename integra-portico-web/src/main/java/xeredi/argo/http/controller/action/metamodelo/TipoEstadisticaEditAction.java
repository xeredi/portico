package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoEstadisticaService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaEditAction.
 */
public final class TipoEstadisticaEditAction extends EntidadEditAction<TipoEstadisticaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3008447139811475030L;

	@Inject
	private TipoEstadisticaService tpesService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificEdit() throws ApplicationException {
		if (accion == AccionCodigo.edit) {
			model = tpesService.select(model.getId(), getIdioma());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificLoadDependencies() throws ApplicationException {
		// noop
	}
}
