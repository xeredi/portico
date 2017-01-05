package xeredi.argo.http.controller.action.facturacion;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.CargoService;
import xeredi.argo.model.facturacion.vo.CargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoRemoveAction.
 */
public final class CargoRemoveAction extends CrudRemoveAction<CargoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6268936117161838481L;

	@Inject
	private CargoService crgoService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		crgoService.delete(model);
	}
}
