package xeredi.argo.http.controller.action.facturacion;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.AspectoCargoService;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoRemoveAction.
 */
public final class AspectoCargoRemoveAction extends CrudRemoveAction<AspectoCargoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8982657228033763093L;

	@Inject
	private AspectoCargoService ascrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		ascrService.delete(model);
	}
}
