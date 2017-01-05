package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.AccionEspecialService;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEspecialRemoveAction.
 */
public final class AccionEspecialRemoveAction extends CrudRemoveAction<AccionEspecialVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3638404948238880930L;

	@Inject
	private AccionEspecialService acesService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		acesService.delete(model);
	}
}
