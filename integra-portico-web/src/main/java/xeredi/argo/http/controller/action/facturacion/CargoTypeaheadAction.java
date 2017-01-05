package xeredi.argo.http.controller.action.facturacion;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.TypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.CargoService;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoLupaAction.
 */
public final class CargoTypeaheadAction extends TypeaheadAction<CargoCriterioVO, CargoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 367706797413439221L;

	@Inject
	private CargoService crgoService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doTypeahead() throws ApplicationException {
		resultList = crgoService.selectTypeaheadList(model, limit);
	}
}
