package xeredi.argo.http.controller.action.facturacion;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.service.ValoracionService;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionRemoveAction.
 */
public final class ValoracionRemoveAction extends CrudRemoveAction<ValoracionVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -968075844003204369L;

	@Inject
	private ValoracionService vlrcService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		vlrcService.delete(model.getId());
	}
}
