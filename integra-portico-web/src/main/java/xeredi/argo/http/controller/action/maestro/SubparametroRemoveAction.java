package xeredi.argo.http.controller.action.maestro;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.service.SubparametroService;
import xeredi.argo.model.maestro.vo.SubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * Accion web de borrado de un Submaestro.
 */
public final class SubparametroRemoveAction extends ItemRemoveAction<SubparametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1199133414671472814L;

	@Inject
	private SubparametroService sprmService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificRemove() throws ApplicationException {
		sprmService.delete(model);
	}
}
