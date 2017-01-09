package xeredi.argo.http.controller.action.proceso;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.proceso.service.ProcesoService;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCancelarAction.
 */
public final class ProcesoRemoveAction extends CrudRemoveAction<ProcesoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3995570668859920070L;

	@Inject
	private ProcesoService prbtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		prbtService.cancelar(model);
	}
}
