package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.ValoracionDetalleService;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleListAction.
 */
public final class ValoracionDetalleListAction
		extends GridListAction<ValoracionDetalleCriterioVO, ValoracionDetalleVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5836376477924004332L;

	@Inject
	private ValoracionDetalleService vlrdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		Preconditions.checkNotNull(model.getVlrlId());

		resultList = vlrdService.selectList(model, getOffset(), limit);
	}
}
