package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoFilterAction.
 */
public final class PuertoFilterAction extends GridFilterAction<PuertoCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7596165170000341208L;

	/** The sprt list. */
	@Getter
	private List<SuperpuertoVO> sprtList;

	@Inject
	private SuperpuertoService sprtService;

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
