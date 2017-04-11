package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.service.FacturaService;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaEditAction.
 */
public final class FacturaEditAction extends CrudEditAction<FacturaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1122946174457133287L;

	/** The aspc. */
	@Getter
	private AspectoVO aspc;

	@Inject
	private AspectoService aspcService;

	@Inject
	private FacturaService fctrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		model = fctrService.select(model.getId(), getIdioma());
		aspc = aspcService.select(model.getAspc().getId(), model.getFref(), getIdioma());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		// noop
	}
}
