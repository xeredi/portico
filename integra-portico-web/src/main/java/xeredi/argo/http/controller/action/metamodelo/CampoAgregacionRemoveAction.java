package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.CampoAgregacionService;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAggregacionRemoveAction.
 */
public final class CampoAgregacionRemoveAction extends CrudRemoveAction<CampoAgregacionVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8109677827127703539L;

	@Inject
	private CampoAgregacionService cmagService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getTpesId());
		Preconditions.checkNotNull(model.getEntd());
		Preconditions.checkNotNull(model.getEntd().getId());

		cmagService.delete(model);
	}
}
