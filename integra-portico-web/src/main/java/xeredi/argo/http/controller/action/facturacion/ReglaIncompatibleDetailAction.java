package xeredi.argo.http.controller.action.facturacion;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.ReglaIncompatibleService;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleDetailAction.
 */
public final class ReglaIncompatibleDetailAction extends CrudDetailAction<ReglaIncompatibleVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7041617693291205414L;

	@Inject
	private ReglaIncompatibleService rginService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = rginService.select(model.getId(), model.getFref());
	}
}
