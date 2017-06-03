package xeredi.argo.http.controller.action.estadistica;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.estadistica.service.PeriodoProcesoService;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoRemoveAction.
 */
public final class PeriodoProcesoRemoveAction extends CrudRemoveAction<PeriodoProcesoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5932718578821008471L;

	@Inject
	private PeriodoProcesoService peprService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		peprService.delete(model);
	}
}
