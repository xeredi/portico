package xeredi.argo.http.controller.action.facturacion;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.FacturaSerieService;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * Accion web de edición de una Serie de Factura.
 */
public final class FacturaSerieEditAction extends CrudEditAction<FacturaSerieVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3708189886402292349L;

	@Inject
	private FacturaSerieService fcsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			model = new FacturaSerieVO();
		} else {
			Preconditions.checkNotNull(model.getId());

			model = fcsrService.select(model.getId());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		// noop
	}
}
