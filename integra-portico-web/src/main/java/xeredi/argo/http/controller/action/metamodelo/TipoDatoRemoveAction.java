package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

/**
 * The Class TipoDatoRemoveAction.
 */
public final class TipoDatoRemoveAction extends CrudRemoveAction<TipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8293109920924616036L;

	/** The tpdt service. */
	@Inject
	private TipoDatoService tpdtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		tpdtService.delete(model);
	}
}
