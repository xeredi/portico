package xeredi.argo.http.controller.action.estadistica;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.estadistica.service.PeriodoProcesoService;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoListAction.
 */
public final class PeriodoProcesoListAction extends GridListAction<PeriodoProcesoCriterioVO, PeriodoProcesoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1113088797514470782L;

	@Inject
	private PeriodoProcesoService peprService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doList() throws ApplicationException {
		resultList = peprService.selectList(model, getOffset(), limit);
	}
}
