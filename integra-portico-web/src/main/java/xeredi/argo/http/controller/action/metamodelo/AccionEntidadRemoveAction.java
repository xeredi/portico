package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.AccionEntidadService;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadRemoveAction.
 */
public final class AccionEntidadRemoveAction extends CrudRemoveAction<AccionEntidadVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7321406198311414130L;

	@Inject
	private AccionEntidadService acenService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		acenService.delete(model);
	}
}
