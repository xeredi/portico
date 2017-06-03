package xeredi.argo.http.controller.action.facturacion;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.TypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.FacturaService;
import xeredi.argo.model.facturacion.vo.FacturaTypeaheadCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaTypeaheadAction.
 */
public final class FacturaTypeaheadAction extends TypeaheadAction<FacturaTypeaheadCriterioVO, FacturaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4164779349249014706L;

	@Inject
	private FacturaService fctrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doTypeahead() throws ApplicationException {
		resultList = fctrService.selectTypeaheadList(model, limit);
	}
}
