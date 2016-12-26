package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.ModuloService;
import xeredi.argo.model.metamodelo.vo.ModuloVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloRemoveAction.
 */
public final class ModuloRemoveAction extends CrudRemoveAction<ModuloVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7556234323466189867L;

	@Inject
	private ModuloService mdloService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		mdloService.delete(model);
	}
}
