package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.TypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoTypeaheadAction.
 */
public final class AspectoTypeaheadAction extends TypeaheadAction<AspectoCriterioVO, AspectoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6939730418443092158L;

	@Inject
	private AspectoService aspcService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doTypeahead() throws ApplicationException {
		Preconditions.checkNotNull(model.getTpsrId());

		resultList = aspcService.selectTypeaheadList(model, limit);
	}
}
