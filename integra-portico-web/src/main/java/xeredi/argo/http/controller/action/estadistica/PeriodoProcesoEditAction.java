package xeredi.argo.http.controller.action.estadistica;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.http.view.estadistica.ProcesoEstadisticaVO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoEditAction.
 */
public final class PeriodoProcesoEditAction extends CrudEditAction<ProcesoEstadisticaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -505923029249050738L;

	/** The sprt service. */
	@Inject
	private SuperpuertoService sprtService;

	/** The sprt list. */
	@Getter
	private List<SuperpuertoVO> sprtList;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		model = new ProcesoEstadisticaVO();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		final SuperpuertoCriterioVO sprtCriterioVO = new SuperpuertoCriterioVO();

		sprtCriterioVO.setIdioma(getIdioma());

		sprtList = sprtService.selectList(sprtCriterioVO);
	}
}
