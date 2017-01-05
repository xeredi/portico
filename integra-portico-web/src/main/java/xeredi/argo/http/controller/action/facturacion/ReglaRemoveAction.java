package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.ReglaService;
import xeredi.argo.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaRemoveAction.
 */
public final class ReglaRemoveAction extends CrudRemoveAction<ReglaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5160365319372545490L;

	@Inject
	private ReglaService rglaService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		rglaService.delete(model);
	}
}
