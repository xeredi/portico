package xeredi.argo.http.controller.action.facturacion;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoRemoveAction.
 */
public final class AspectoRemoveAction extends CrudRemoveAction<AspectoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2102022344017937240L;

	@Inject
	private AspectoService aspcService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		aspcService.delete(model);
	}
}
