package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.AccionBaseService;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseRemoveAction.
 */
public final class AccionBaseRemoveAction extends CrudRemoveAction<AccionBaseVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4615648744428447373L;

	@Inject
	private AccionBaseService acbsService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		acbsService.delete(model);
	}
}
