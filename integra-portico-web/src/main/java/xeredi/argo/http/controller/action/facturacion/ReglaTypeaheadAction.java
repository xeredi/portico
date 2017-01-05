package xeredi.argo.http.controller.action.facturacion;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.TypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.ReglaService;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class RegaLupaAction.
 */
public final class ReglaTypeaheadAction extends TypeaheadAction<ReglaCriterioVO, ReglaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -657608329114959872L;

	@Inject
	private ReglaService rglaService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doTypeahead() throws ApplicationException {
		resultList = rglaService.selectTypeaheadList(model, limit);
	}
}
