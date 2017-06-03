package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoEstadisticaService;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaSaveAction.
 */
public final class TipoEstadisticaSaveAction extends EntidadSaveAction<TipoEstadisticaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4043292220180385996L;

	@Inject
	private TipoEstadisticaService tpesService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificValidate() throws ApplicationException {
		// noop
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			tpesService.insert(model, i18nMap);

			break;
		case edit:
			tpesService.update(model, i18nMap);

			break;
		default:
			throw new Error("Accion no soportada: " + accion);
		}
	}
}
