package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.AccionEntidadService;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadDetailAction.
 */
public final class AccionEntidadDetailAction extends CrudDetailAction<AccionEntidadVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6926170829964416671L;

	@Inject
	private AccionEntidadService acenService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = acenService.select(model.getId(), getIdioma());
	}
}
