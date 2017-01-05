package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.CargoService;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoListAction.
 */
public final class CargoListAction extends GridListAction<CargoCriterioVO, CargoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6203976676780090103L;

	@Inject
	private CargoService crgoService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		if (model.getFechaVigencia() == null && !model.isMostrarHistorico()) {
			model.setFechaVigencia(Calendar.getInstance().getTime());
		}

		resultList = crgoService.selectList(model, getOffset(), limit);
	}
}
