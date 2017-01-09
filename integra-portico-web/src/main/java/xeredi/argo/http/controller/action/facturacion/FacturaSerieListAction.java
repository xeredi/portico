package xeredi.argo.http.controller.action.facturacion;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.FacturaSerieService;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieListAction.
 */
public final class FacturaSerieListAction extends GridListAction<FacturaSerieCriterioVO, FacturaSerieVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8695014228430229258L;

	@Inject
	private FacturaSerieService fcsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = fcsrService.selectList(model, getOffset(), limit);
	}
}
