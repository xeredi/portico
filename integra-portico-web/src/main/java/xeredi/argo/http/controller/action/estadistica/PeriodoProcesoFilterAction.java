package xeredi.argo.http.controller.action.estadistica;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoFilterAction.
 */
public final class PeriodoProcesoFilterAction extends GridFilterAction<PeriodoProcesoCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4100651934689033353L;

	@Inject
	private SuperpuertoService sprtService;

	/** The subps. */
	@Getter
	private List<SuperpuertoVO> sprtList;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doPrepareFilter() throws ApplicationException {
		// noop
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

		sprtCriterio.setIdioma(getIdioma());

		sprtList = sprtService.selectList(sprtCriterio);
	}
}
