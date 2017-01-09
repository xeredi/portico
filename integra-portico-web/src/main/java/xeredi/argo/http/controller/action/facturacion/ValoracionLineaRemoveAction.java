package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.ValoracionLineaService;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaRemoveAction.
 */
public final class ValoracionLineaRemoveAction extends CrudRemoveAction<ValoracionLineaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -600415209403363458L;

	@Inject
	private ValoracionLineaService vlrlService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());
		Preconditions.checkNotNull(model.getVlrcId());

		vlrlService.delete(model);
	}
}
