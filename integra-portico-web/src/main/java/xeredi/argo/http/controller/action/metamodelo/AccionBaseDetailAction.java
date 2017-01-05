package xeredi.argo.http.controller.action.metamodelo;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.AccionBaseService;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseDetailAction.
 */
public final class AccionBaseDetailAction extends CrudDetailAction<AccionBaseVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1098675557065003093L;

	@Inject
	private AccionBaseService acbsService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = acbsService.select(model.getId());
	}
}
