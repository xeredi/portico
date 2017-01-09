package xeredi.argo.http.controller.action.facturacion;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.ValoracionLineaService;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaListAction.
 */
public final class ValoracionLineaListAction extends GridListAction<ValoracionLineaCriterioVO, ValoracionLineaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1895265213593160732L;

	@Inject
	private ValoracionLineaService vlrlService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = vlrlService.selectList(model, getOffset(), limit);
	}
}
