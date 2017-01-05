package xeredi.argo.http.controller.action.facturacion;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.ReglaIncompatibleService;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleRemoveAction.
 */
public final class ReglaIncompatibleRemoveAction extends CrudRemoveAction<ReglaIncompatibleVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4230713466511401390L;

	@Inject
	private ReglaIncompatibleService rginService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		rginService.delete(model);
	}
}
