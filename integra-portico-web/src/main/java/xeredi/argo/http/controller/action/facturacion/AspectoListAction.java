package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoListAction.
 */
public final class AspectoListAction extends GridListAction<AspectoCriterioVO, AspectoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6610833697858691088L;

	@Inject
	private AspectoService aspcService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		if (model.getFechaVigencia() == null) {
			model.setFechaVigencia(Calendar.getInstance().getTime());
		}

		resultList = aspcService.selectList(model, getOffset(), limit);
	}
}
