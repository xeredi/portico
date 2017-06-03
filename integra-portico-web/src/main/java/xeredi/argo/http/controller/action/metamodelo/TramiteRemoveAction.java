package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TramiteService;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteRmoveAction.
 */
public final class TramiteRemoveAction extends CrudRemoveAction<TramiteVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8053448630800994429L;

	@Inject
	private TramiteService trmtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		trmtService.delete(model);
	}
}
