package xeredi.argo.http.controller.action.proceso;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.OrderByElement.OrderByType;
import xeredi.argo.model.proceso.service.ProcesoService;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO.ProcesoOrderByColumn;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoListAction.
 */
public final class ProcesoListAction extends GridListAction<ProcesoCriterioVO, ProcesoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4892003930947515760L;

	@Inject
	private ProcesoService prbtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		if (model.getOrderByList().isEmpty()) {
			model.addOrderBy(ProcesoOrderByColumn.prbt_falta.name(), OrderByType.DESC);
		}

		resultList = prbtService.selectList(model, getOffset(), limit);
	}
}
