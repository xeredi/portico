package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.FacturaSerieService;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;

// TODO: Auto-generated Javadoc
/**
 * Accion Web de borrado de una Serie de Factura.
 */
public final class FacturaSerieRemoveAction extends CrudRemoveAction<FacturaSerieVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5331771894462064607L;

	@Inject
	private FacturaSerieService fcsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		fcsrService.delete(model);
	}
}
