package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.AspectoCargoService;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoDetailAction.
 */
public final class AspectoCargoDetailAction extends CrudDetailAction<AspectoCargoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3728076328413890092L;

	@Inject
	private AspectoCargoService ascrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		model = ascrService.select(model.getId(), model.getFref(), getIdioma());
	}
}
