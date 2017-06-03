package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoEstadisticaService;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaListAction.
 */
public final class TipoEstadisticaListAction extends GridListAction<TipoEstadisticaCriterioVO, TipoEstadisticaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3250106088197977726L;

	@Inject
	private TipoEstadisticaService tpesService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = tpesService.selectList(model, getOffset(), limit);
	}
}
