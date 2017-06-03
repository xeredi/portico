package xeredi.argo.http.controller.action.facturacion;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.ValoracionDetalleService;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleRemoveAction.
 */
public final class ValoracionDetalleRemoveAction extends CrudRemoveAction<ValoracionDetalleVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1970434275265288322L;

	@Inject
	private ValoracionDetalleService vlrdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());
		Preconditions.checkNotNull(model.getVlrlId());

		vlrdService.delete(model);
	}
}
